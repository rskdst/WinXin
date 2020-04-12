#!/usr/bin/env python
# -*- coding:utf-8 -*-
# @Time : 2020/4/7 20:21
# @Author : liujing
# @File : API.py

"""接口规范"""

"""
参数：
    status:执行状态
        0：请求成功
        1：创建成功
        -1：创建失败 
        2：禁止访问
        3：资源未找到
        4：需要认证
    msg:执行信息
    data:返回数据
"""


def jsonData(status, msg, data):
    dict = {"status": status, "msg": msg, "data": data}
    return dict


"""
jwt认证
"""

import jwt
import datetime
from jwt import exceptions
from django.conf import settings
from django.utils.deprecation import MiddlewareMixin
from rest_framework.exceptions import AuthenticationFailed
from rest_framework.authentication import BaseAuthentication


# 生成jwt
def create_token(phone):
    """
    :param phone: 用户唯一标识
    :param refresh: 自动刷新期限
    :return:
    """
    payload = {
        "phone": phone,
        "exp": datetime.datetime.utcnow() +datetime.timedelta(days=7),
        'iat': datetime.datetime.utcnow(),
        "iss": "weixin.com"
    }
    token = str(jwt.encode(payload, settings.SECRET_KEY, algorithm="HS512"), encoding="utf-8")
    return token

# jwt认证
class JwtAuthentication(BaseAuthentication):
    def authenticate(self, request):
        token = request.META.get("HTTP_AUTHORIZATION")
        try:
            payload = jwt.decode(bytes(token, encoding="utf-8"), settings.SECRET_KEY, True, algorithms=["HS512"], )
        except exceptions.ExpiredSignatureError:
            raise AuthenticationFailed({"status": 4, "msg": "token已失效", "data": {}})
        except jwt.DecodeError:
            raise AuthenticationFailed({"status": 4, "msg": "token认证失败", "data": {}})
        except jwt.InvalidTokenError:
            raise AuthenticationFailed({"status": 4, "msg": "非法的token", "data": {}})
        return (payload, token)



# # jwt认证
# class JwtAuthentication(BaseAuthentication):
#     def authenticate(self, request):
#         token = request.META.get("HTTP_AUTHORIZATION")
#         try:
#             payload = jwt.decode(bytes(token, encoding="utf-8"), settings.SECRET_KEY, True, algorithms=["HS512"], )
#         except exceptions.ExpiredSignatureError:
#             payload = jwt.decode(bytes(token, encoding="utf-8"), settings.SECRET_KEY, False, algorithms=["HS512"], )
#             now = int(
#                 time.mktime(time.strptime(datetime.datetime.now().strftime('%Y-%m-%d %H:%M:%S'), "%Y-%m-%d %H:%M:%S")))
#             if now < payload["refresh"] and (payload["refresh"] - payload["exp"]) >= 86400 * 7:
#                 new_exp = now + 86400 * 7
#             elif now < payload["refresh"] and (payload["refresh"] - payload["exp"]) < 86400 * 7:
#                 new_exp = now + (payload["refresh"] - payload["exp"])
#             else:
#                 raise AuthenticationFailed({"status": 4, "msg": "token已失效", "data": {}})
#             token = create_token(payload["phone"], new_exp, payload["refresh"])
#             return (payload, token)
#         except jwt.DecodeError:
#             raise AuthenticationFailed({"status": 4, "msg": "token认证失败", "data": {}})
#         except jwt.InvalidTokenError:
#             raise AuthenticationFailed({"status": 4, "msg": "非法的token", "data": {}})
#         return (payload, token)
#
#
# class JwtMiddleware(MiddlewareMixin):
#     """
#     自动更新token
#     """
#
#     def process_request(self, request):
#         self.token = request.META.get("HTTP_AUTHORIZATION")
#
#     def process_response(self, request, response):
#         try:
#             if request.auth and request.auth != self.token:
#                 new_response = eval(str(response.content, encoding="utf-8"))
#                 new_response["token"] = request.auth
#                 new_response = json.dumps(new_response)
#                 response.content = new_response
#                 return response
#             return response
#         except:
#             return response
