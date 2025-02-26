<template>
	<view class="my-page">
		<view class="user-info">
			<image :src="userIcon" class="u-icon" />
			<view class="login-button" v-if="!user">
				<text class="login-text" @click="goToLogin">立即登录</text>
			</view>
			<view v-else>
				<text class="username">{{ user.loginname }}</text>
			</view>
		</view>

		<view class="user-stats">
			<view class="stat-item" v-for="(value, label) in stats" :key="label">
				<text class="stat-value">{{ value }}</text>
				<text class="stat-label">{{ label }}</text>
			</view>
		</view>

		<view class="menu-list">
			<view class="menu-item" v-for="(label, path) in menuItems" :key="path" @click="goPath(path)">
				<text>{{ label }}</text>
				<text class="arrow">></text>
			</view>
		</view>

		<view>
			<text class="u-txt" @click="logout">退出</text>
		</view>
	</view>
</template>

<script>
	import {
		isLogin,
		prompt,
		goPage
	} from "../../util/info.js";

	export default {
		data() {
			return {
				user: null,
				userIcon: "",
				stats: {
					余额: '0.00',
					积分: '0',
					卡: '0',
					优惠券: '0'
				},
				menuItems: {
					order: "订单中心",
					car: "购物车",
					address: "收货地址"
				}
			};
		},
		onLoad() {
			this.getInfo();
		},
		onShow() {
			this.getInfo();
		},
		methods: {
			getInfo() {
				if (!isLogin()) {
					prompt("请先登录", "error");
					setTimeout(() => {
						goPage("/pages/login/login");
					}, 200);
				} else {
					this.user = JSON.parse(uni.getStorageSync("sanuser"))
					this.userIcon = "/static/imgs_index/" + this.user.icon;
					console.log("this.userIcon", this.userIcon)
				}
			},
			getUser() {
				if (isLogin()) {
					const userinfo = JSON.parse(uni.getStorageSync("sanuser"));
					console.log("const userinfo", JSON.parse(uni.getStorageSync("sanuser")))
					if (userinfo != null) {
						this.username = userinfo.loginname;
						console.log("this.username", userinfo.loginname)
					}
				}
			},

			logout() {
				uni.showModal({
					title: "退出",
					content: "确认退出吗？",
					success: (res) => {
						if (res.confirm) {
							uni.clearStorage();
							window.location = "pages/index/index";
						}
					}
				});
			},
			goToLogin() {
				uni.navigateTo({
					url: '/pages/login/login'
				});
			},
			goPath(type) {
				if (type === 'car') {
					uni.switchTab({
						url: '/pages/goods/goods'
					});
				} else {
					const paths = {
						order: "/pages/order/order",
						address: '/pages/address/address'
					};
					uni.navigateTo({
						url: paths[type]
					});
				}
			}
		}
	};
</script>

<style scoped>
	.my-page {
		padding: 20px;
		height: 100%;
		background-color: #fff0f5;
		/* 淡粉色背景 */
	}

	.user-info {
		display: flex;
		align-items: center;
		margin-bottom: 20px;
	}

	.u-icon {
		width: 80px;
		height: 80px;
		border-radius: 50%;
		margin-right: 15px;
	}

	.login-button {
		background-color: #FFC0CB;
		padding: 10px 20px;
		border-radius: 20px;
	}

	.login-text {
		color: white;
		font-size: 18px;
		font-weight: bold;
	}

	.username {
		color: black;
		/* 黑色字体 */
		font-size: 20px;
		/* 更大字体 */
		font-weight: bold;
	}

	.user-stats {
		display: flex;
		justify-content: space-between;
		background-color: white;
		padding: 15px;
		border-radius: 8px;
		margin-bottom: 20px;
	}

	.stat-item {
		display: flex;
		flex-direction: column;
		align-items: center;
	}

	.stat-value {
		font-size: 16px;
		font-weight: bold;
		margin-bottom: 5px;
	}

	.stat-label {
		font-size: 12px;
		color: #666;
	}

	.menu-list {
		background-color: white;
		border-radius: 8px;
	}

	.menu-item {
		display: flex;
		justify-content: space-between;
		padding: 15px;
		border-bottom: 1px solid #eee;
	}

	.menu-item:last-child {
		border-bottom: none;
	}

	.arrow {
		color: #999;
	}

	.u-txt {
		background-color: #FFC0CB;
		/* 粉色按钮 */
		padding: 10px 40px;
		border-radius: 20px;
		margin: 20px auto;
		display: block;
		width: fit-content;
		color: white;
		font-size: 18px;
		font-weight: bold;
	}
</style>
