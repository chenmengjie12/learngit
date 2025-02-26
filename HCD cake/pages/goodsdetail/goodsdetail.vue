<template>
	<view>
		<pagetitle title=" HCD cake  "></pagetitle>
		<image :src="oneMenu.pic" class="u-img"></image>
		<view class="price-all">
			<view class="ptxt">
				<view class="u-price1">￥{{Math.ceil(oneMenu.price*0.8)}}</view>
				<view class="u-txt">{{oneMenu.mname}}</view>
			</view>
			<view class="price-info">
				<view class="u-price2">原价 {{oneMenu.price}}</view>
				<view class="u-sn">
					<view class="u-sales">已售 {{oneMenu.sales}}</view>
					<text class="m-txt"></text>
					<view class="u-num">剩余 {{oneMenu.num}}</view>
				</view>
			</view>
		</view>
		<view class="butPane">
			<button class="but1" @click="buy">立即购买</button>
			<button class="but2" @click="addcart">加入购物车</button>
		</view>
	</view>
</template>

<script>
	import {
		isLogin,
		prompt
	} from "../../util/info.js"
	export default {
		data() {
			return {
				oneMenu: {}
			}
		},
		onLoad(option) {
			console.log("option", JSON.parse(option.item));
			this.oneMenu = JSON.parse(option.item);
		},
		methods: {
			buy() {
				if (!isLogin()) {
					prompt("请先登录", "error");
				} else {

				}
			},
			addcart() {
				if (!isLogin()) {
					prompt("请先登录", "error");
				} else {
					let user = JSON.parse(uni.getStorageSync("sanuser"));
					let uid = user.id;
					let mid = this.oneMenu.mid;
					let obj = {
						uid,
						mid
					}
					console.log("obj", obj)
					uni.request({
						url: "http://localhost:9998/cart/add",
						method: "post",
						data: obj,
						success: (res) => {
							console.log("res", res)
							if (res.data.state == 0) {
								// console.log("Adding to cart successful");
								prompt("已经添加到购物车", "error");
								console.log("After showToast");
							} else {

							}
						}

					})
				}
			}
		}
	}
</script>

<style scoped>
	.u-img {
		width: 100%;
		height: 800rpx;
		position: relative;
	}

	.price-all {
		display: flex;
		/* flex-wrap: wrap;
		justify-content: space-between; */
		/* align-items: center; */
		font-family: Arial, sans-serif;
		flex-direction: column;
	}

	.u-price1 {
		font-size: 24px;
		font-weight: bold;
		color: #ff69b4;
		padding-top: 20rpx;
		/* flex-direction:row; */

	}
	.ptxt {
		display: flex;
		justify-content: space-between;
		align-items: center;
	}
	.u-txt{
		display: flex;
		padding-right: 20rpx;
	}

	.price-info {
		display: flex;
		justify-content: space-between;
		align-items: center;
	}

	.u-price2 {
		font-size: 12px;
		text-decoration: line-through;
		color: #999;
		padding-left: 10rpx;
		/* flex-direction: column; */
	}

	.u-sn {
		display: flex;
		/* gap: 20rpx; */
	}

	.m-txt::before {
		content: "";
		position: sticky;
		width: 30%;
		height: 45rpx;
		background: gainsboro;
		border-radius: 1rpx;
		left: 30rpx;
		right: 20rpx;
		top: 55rpx;
		margin-left: 10rpx;
		display: flex;
		flex-direction: column;
	}

	.u-sales,
	.u-num {
		font-size: 12px;
		color: #999;
		margin-left: 10px;
		padding-right: 20rpx;
	}

	.butPane {
		width: 600rpx;
		height: 100rpx;
		display: flex;
		position: relative;
		left: 150rpx;
		border-radius: 25px;
		overflow: hidden;
	}

	.but1,
	.but2 {
		flex: 1;
		cursor: pointer;
		font-size: 40srpx;
		border: none;
	}

	.but1 {
		background-color: #fff0f5;
		color: #ff69b4;
		border-top-left-radius: 25px;
		border-bottom-left-radius: 25px;
	}

	.but2 {
		background-color: #ff69b4;
		color: #fff0f5;
	}
</style>
