<template>
    <view class="login-container">
        <view class="header">
            <text class="back-icon" @click="goBack">＜</text>
        </view>
        <image class="logo" src="/static/imgs_index/logo1.jpg" mode="aspectFit"></image>
        <view class="title">欢迎来到甜蜜蛋糕屋</view>
        <view class="form">
            <input class="input" type="text" placeholder="请输入用户名" v-model="formData.loginname" />
            <input class="input" type="password" placeholder="请输入密码" v-model="formData.pass" />
            <button class="login-btn" @click="login">登录</button>
        </view>
        <view class="footer">
            <text class="register" @click="goToRegister">还没有账号？立即注册</text>
            <text class="forgot-password" @click="forgotPassword">忘记密码</text>
        </view>
        <view class="decoration">
            <image class="cake-img" src="/static/cake-decoration.png" mode="aspectFit"></image>
        </view>
    </view>
</template>

<script>
    import { prompt } from "../../util/info.js"
    export default {
        data() {
            return {
                formData: {
                    loginname: "",
                    pass: ""
                }
            }
        },
        methods: {
            login() {
                console.log(this.formData);
                uni.request({
                    url: "http://localhost:9998/user/login",
                    method: "post",
                    data: this.formData,
                    success: (res) => {
                        console.log("res", res);
                        if (res.data.state == 0) {
                            uni.setStorageSync("sanuser", JSON.stringify(res.data.datas))
                            window.location = "pages/index/index"
                        } else {
                            prompt("登录失败", "error");
                        }
                    }
                })
            },
            goToRegister() {
                uni.navigateTo({
                    url: '/pages/register/register'
                });
            },
            forgotPassword() {
                uni.navigateTo({
                    url: '/pages/forgot-password/forgot-password'
                });
            },
            goBack() {
                uni.switchTab({
                    url: '/pages/index/index'
                });
            }
        }
    }
</script>

<style scoped>
    .login-container {
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        height: 100vh;
        background-color: #FFF0F5;
        position: relative;
    }

    .header {
        position: absolute;
        top: 20rpx;
        left: 20rpx;
    }

    .back-icon {
        font-size: 40rpx;
        color: #FF69B4;
        cursor: pointer;
    }

    .logo {
        width: 200rpx;
        height: 200rpx;
        margin-bottom: 30rpx;
        border-radius: 50%;
    }

    .title {
        font-size: 36rpx;
        color: #FF69B4;
        margin-bottom: 50rpx;
        font-weight: bold;
    }

    .form {
        width: 80%;
    }

    .input {
        background-color: #FFFFFF;
        border: 2rpx solid #FFB6C1;
        border-radius: 30rpx;
        padding: 20rpx;
        margin-bottom: 30rpx;
        font-size: 28rpx;
    }

    .login-btn {
        background-color: #FF69B4;
        color: #FFFFFF;
        border-radius: 30rpx;
        padding: 20rpx;
        font-size: 32rpx;
        font-weight: bold;
        margin-bottom: 20rpx;
    }

    .footer {
        margin-top: 20rpx;
        display: flex;
        justify-content: space-between;
        width: 80%;
    }

    .register,
    .forgot-password {
        color: #FF69B4;
        font-size: 26rpx;
    }

    .decoration {
        position: absolute;
        bottom: 0;
        right: 0;
    }

    .cake-img {
        width: 200rpx;
        height: 200rpx;
        opacity: 0.5;
    }
</style>
