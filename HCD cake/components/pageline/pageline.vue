<template>
	<view class="g-title">
		<text class="u-title">{{title}}</text>
		<view class="u-more">
			<text class="u-txt"></text>
		</view>
	</view>
</template>

<script>
	export default {
		name:"pageline",
		props:["title"],
		data() {
			return {
				
			};
		}
	}
</script>

<style scoped>
	.g-title{
		width: 700rpx;
		height: 80rpx;
		line-height: 80rpx;
		color: black;
		position: relative;
		padding-left: 50rpx;
		display: flex;
		flex-direction: row;
		justify-content: space-between;
		font-size: 26rpx;
		margin-bottom: 10rpx;
		margin-right: 50rpx;
	}
	.g-title::before{
		content: "";
		position: absolute;
		width: 1rpx;
		height: 21rpx;
		background: #ff6666;
		border-radius: 1rpx;
		left: 10rpx;
		top: 30rpx;
		margin-left:8rpx;
		margin-right: 26px;
		display: flex;
		flex-direction: column;
		transform: rotate(90deg);
		border-bottom:  1rpx solid #ff69b4;
	}
	.u-title{
		font-weight: bold;
		font-size: 28rpx;
	}

</style>