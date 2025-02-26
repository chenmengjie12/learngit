<template>
    <view class="page">
        <pagetitle title=""></pagetitle>
        <view v-if="cartData.length > 0">
            <view class="g-cart">
                <view class="g-cart-main">
                    <view class="g-cart-item" v-for="(item, index) in cartData" :key="index">
                        <image :src="item.pic" class="u-img"></image>
                        <view class="u-item">
                            <text class="u-txtm">{{ item.mname }}</text>
                            <text class="u-txtn">数量: {{ item.num }}</text>
                            <text class="u-txtp">￥{{ item.price }}</text>
                            <text class="delete-btn" @click="delHandel(item.cid)">删除</text>
                        </view>
                    </view>
                </view>
            </view>
            <view class="g-total">
                <text class="g-price">合计: ￥{{ totalprice }}</text>
            </view>
            <button class="pay-btn" @click="goToPayment">去支付</button>
        </view>
        <view v-else class="empty-cart">
            <view class="cake-icon">🎂</view>
            <text class="empty-text">您还没有选购商品！</text>
            <text class="empty-subtext">快去选购吧！</text>
        </view>
    </view>
</template>

<script>
import { isLogin, prompt, goPage } from "../../util/info.js"
export default {
    data() {
        return {
            uid: 0,
            cartData: []
        }
    },
    onLoad() {
        this.getInfo();
    },
    onShow() {
        this.getInfo();
    },
    computed: {
        totalprice() {
            return this.cartData.reduce((sum, item) => sum + item.num * item.price, 0);
        }
    },
    methods: {
        getInfo() {
            if (!isLogin()) {
                prompt("请先登录", "error");
                setTimeout(() => {
                    goPage("/pages/login/login");
                }, 200);
            } else {
                this.getData();
            }
        },
        getData() {
            const user = JSON.parse(uni.getStorageSync("sanuser"));
            this.uid = user.id;
            uni.request({
                url: `http://localhost:9998/cart/listbyuid?uid=${this.uid}`,
                method: "get",
                success: (res) => {
                    const menuData = res.data.datas.map(item => ({
                        ...item,
                        pic: "/static/menu/" + item.pic
                    }));
                    this.cartData = menuData;
                }
            });
        },
        delHandel(cid) {
            uni.request({
                url: `http://localhost:9998/cart/del?cid=${cid}`,
                method: "delete",
                success: (res) => {
                    prompt(res.data.msg);
                    this.getData();
                }
            });
        },
        goToPayment() {
            uni.navigateTo({
                url: '/pages/payment/payment'
            });
        }
    }
}
</script>

<style scoped>
.page {
    background-color: #fff0f5; /* 淡粉色背景 */
    min-height: 100vh;
    padding: 20rpx;
}

.g-cart {
    padding: 20rpx;
    background-color: #fff;
    border-radius: 20rpx;
    box-shadow: 0 2rpx 8rpx rgba(0, 0, 0, 0.1);
}

.g-cart-main {
    display: flex;
    flex-direction: column;
}

.g-cart-item {
    display: flex;
    margin-bottom: 20rpx;
    align-items: center;
    border-bottom: 1rpx solid #ffe4e1;
    padding-bottom: 10rpx;
}

.u-img {
    width: 100rpx;
    height: 100rpx;
    border-radius: 15rpx;
    margin-right: 20rpx;
}

.u-item {
    flex-grow: 1;
    display: flex;
    flex-direction: column;
}

.u-txtm {
    font-size: 30rpx;
    color: #ff69b4;
    font-weight: bold;
}

.u-txtn, .u-txtp {
    font-size: 26rpx;
    color: #555;
}

.u-txtp {
    color: #ff69b4;
}

.delete-btn {
    font-size: 26rpx;
    color: #ff69b4;
    cursor: pointer;
    align-self: flex-end;
}

.g-total {
    font-size: 34rpx;
    margin-top: 20rpx;
    text-align: right;
    color: #ff69b4;
    font-weight: bold;
}

.pay-btn {
    width: 90%;
    margin: 20rpx auto;
    padding: 20rpx;
    background-color: #ff69b4;
    color: #fff;
    text-align: center;
    border-radius: 30rpx;
    font-size: 32rpx;
    font-weight: bold;
    box-shadow: 0 4rpx 8rpx rgba(0, 0, 0, 0.2);
}

.empty-cart {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    height: 70vh;
    background-color: #fff4f4;
}

.cake-icon {
    font-size: 100rpx;
    margin-bottom: 20rpx;
}

.empty-text, .empty-subtext {
    font-size: 34rpx;
    color: #ff69b4;
    font-weight: bold;
}
</style>
