#!/usr/bin/env python
# -*- coding:utf-8 -*-
# @Time : 2020/4/7 20:21
# @Author : liujing
# @File : API.py

"""接口规范"""

"""
 response：
----------------------------------------
{
   status: 200,               // 详见【status】

   data: {
      code: 1,                // 详见【code】
      data: {} || [],         // 数据
      message: '成功',        // 存放响应信息提示,显示给客户端用户【须语义化中文提示】
      ...                     // 其它参数，如 total【总记录数】等
   },

   msg: '成功',            // 存放响应信息提示,显示给客户端用户【须语义化中文提示】
}
----------------------------------------
【status】:
           200: OK       400: Bad Request        500：Internal Server Error       
                         401：Unauthorized
                         403：Forbidden
                         404：Not Found

【code】:
         1: 获取数据成功 | 操作成功             0：获取数据失败 | 操作失败
         -1： token获取失败 | 重新登录
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
            raise AuthenticationFailed({"status": 403, "msg": "token已失效", "data": {"code":-1,"data":{},"message":"token已失效"}})
        except jwt.DecodeError:
            raise AuthenticationFailed({"status": 403, "msg": "token认证失败", "data": {"code":-1,"data":{},"message":"token认证失败"}})
        except jwt.InvalidTokenError:
            raise AuthenticationFailed({"status": 403, "msg": "非法的token", "data": {"code":-1,"data":{},"message":"非法的token"}})
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
