<template>
	<view>
		<view class="m-title">
			<uni-icons type="left" size="18" color="black" name="back" @click="goToGoods()"></uni-icons>
			<text>{{title}}</text>
			<uni-icons type="shop" size="20" color="black" name="home" @click="goToIndex()"></uni-icons>
			<text></text>
		</view>
	</view>
</template>

<script>
	export default {
		name:"pagetitle",
		props:["title"],
		data() {
			return {
				
			};
		},
		methods: {
			goToGoods() {
			  // 跳转到购物车页面
			  uni.switchTab({
			    url:"/pages/goods/goods", // 替换为你的购物车页面路径
			  });
			},
		  goToIndex() {
		    // 跳转到购物车页面
		    uni.switchTab({
		      url: '/pages/index/index', // 替换为你的购物车页面路径
		    });
		  },
		},
	}
</script>

<style scoped>
	.m-title{
		display: flex;
	
		width: 750rpx;
		flex-direction: row;
		height: 50;
		line-height: 150rpx;
		background-color:#fff0f5;
		font-weight: bold;
		color: black;
		font-size: 27rpx;
	}

</style>