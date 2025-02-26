<template>
	<view class="g-log">
		<text class="u-txt">HCD cake</text>
	</view>
</template>

<script>
	export default {
		name:"indextitle",
		data() {
			return {
				
			};
		}
	}
</script>

<style scoped>
	.g-log{
		display: flex;
		justify-content: space-around;
		width:100%;
		height: 150rpx;
		flex-direction: row;
		background-color: pink;
		font-weight: bold;
	}
    .u-txt{
		line-height: 150rpx;
		color: black;
		font-size: 40rpx;
	}
</style>