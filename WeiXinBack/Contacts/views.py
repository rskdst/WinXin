from django.shortcuts import render
from django.http import JsonResponse
from rest_framework.views import APIView
# Create your views here.

class Tongxunlu(APIView):
    def get(self,req):
        return JsonResponse({"data":"这是通讯录"})
    def post(self,req):
        return JsonResponse({"data":"这是通讯录"})
