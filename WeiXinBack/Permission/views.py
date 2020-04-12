import os
import jwt
import hashlib
import base64
from django.conf import settings
from WeiXin.API import jsonData,create_token
from Permission.Serializer import *
from django.http import JsonResponse
from Permission.models import UserInfo
from django.shortcuts import render,HttpResponse
from rest_framework.views import APIView,Response
from rest_framework.permissions import IsAuthenticated


def encryption(password):
    password = hashlib.md5(password.encode(encoding="utf-8")).hexdigest()
    return password

# Create your views here.

class Register(APIView):
    def post(self,req):
        phone = req.POST.get("phone")
        if UserInfo.objects.filter(phone=phone):
            return JsonResponse(jsonData(-1,"用户已存在",{}))
        else:
            password = encryption(req.POST.get("password"))
            avatar_url = ""
            if req.POST.get("avatar")[0]:
                avatar = req.POST.get("avatar").split(";base64,")[1]
                img = base64.b64decode(avatar)
                img_url = os.path.join(settings.BASE_DIR, "static/avatar/{}.png".format(req.POST.get("phone")))
                with open(img_url, "wb")as f:
                    f.write(img)
                avatar_url = img_url.split("static/")[1]
            UserInfo.objects.create(
                nickname=req.POST.get("nickname"),
                address=req.POST.get("address"),
                phone=req.POST.get("phone"),
                password=password,
                avatar=avatar_url,
            )
            return JsonResponse(jsonData(1,"用户创建成功",{}))


class Login(APIView):
    authentication_classes = []
    def post(self,req):
        phone = req.POST.get("phone")
        password = req.POST.get("password")
        if UserInfo.objects.filter(phone=phone):
            password = encryption(password)
            if UserInfo.objects.filter(phone=phone,password=password):
                try:
                    token = req.META.get("HTTP_AUTHORIZATION")
                    payload = jwt.decode(bytes(token, encoding="utf-8"), settings.SECRET_KEY, True, algorithms=["HS512"], )
                    return JsonResponse(jsonData(0, "登陆成功", {}))
                except:
                    print("重新生成token")
                    token = create_token(phone)
                    return JsonResponse(jsonData(0,"登陆成功",{"token":token}))
            else:
                return JsonResponse(jsonData(3,"密码错误",{}))
        else:
            return JsonResponse(jsonData(4,"用户未创建",{}))


