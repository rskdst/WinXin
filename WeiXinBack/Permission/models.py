from django.db import models

# Create your models here.

class UserInfo(models.Model):
    nickname = models.CharField(max_length=8,unique=True,verbose_name="昵称")
    address = models.IntegerField(default=0,verbose_name="国家")
    phone = models.CharField(max_length=11,verbose_name="手机号")
    password = models.CharField(max_length=100,verbose_name="密码")
    avatar = models.CharField(max_length=100,verbose_name="头像")

    class Meta:
        db_table = "userinfo"

