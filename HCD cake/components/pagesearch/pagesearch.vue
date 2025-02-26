
<template>
	<view class="g-search">
		<view class="m-search">
			<icon type="search" size="18" class="u-icon"/>
			<input class="u-input" placeholder="sechdata"/>
		</view>
	</view>
</template>

<script>
	export default {
		name:"pagesearch",
		data() {
			return {
				
			};
		}
	}
</script>

<style scoped>
	.g-search{
		display: flex;
		flex-direction: row;
		justify-content: space-around;
		height: 100rpx;
		line-height: 100rpx;
		background: #f5f5f5;
	}
	.m-search{
		background: #fff;
		border-radius: 20rpx;
		width: 90%;
		margin: 10rpx;
		padding-left: 10rpx;
		line-height: 70rpx;
		display: flex;
		flex-direction: row;
	}
	.u-input{
		position: relative;
		margin-left: 10rpx;

		padding-left: 10rpx;
	}
	.u-icon{
		margin-left: 10rpx;
		margin-top: 1rpx;
		padding-top: 5rpx;
		padding-left: 10rpx;
	}

</style>