<template>
    <view class="g-nav">
        <view class="u-item" v-for="(item, index) in navImage" :key="item.id">
            <view @click="navigateTo(item)">
                <image :src="item.pic" class="u-img"></image>
                <text class="u-txt">{{item.txt}}</text>
            </view>
        </view>
    </view>
</template>

<script>
    export default {
        name: "pagenav",
        props: ["navImage"],
        methods: {
            navigateTo(item) {
                let category = '';
                switch (item.txt) {
                    case '蛋糕':
                        category = 'cake';
                        break;
                    case '甜品':
                        category = 'dessert';
                        break;
                    case '饮品':
                        category = 'drink';
                        break;
                    case '小食':
                        category = 'private';
                        break;
                    default:
                        category = '';
                }
                
                if (category) {
                    // 将选中的分类存储到本地存储
                    uni.setStorageSync('selectedCategory', category);
                    
                    uni.switchTab({
                        url: '/pages/goods/goods'
                    });
                }
            }
        }
    }
</script>

<style scoped>
	.g-nav{
		padding-top: 30rpx;
		padding-bottom: 30rpx;
		width: 750rpx;
		display: flex;
		justify-content: space-around;
		font-size: 30rpx;
		background-color: #ff0f5;
		text-align: center;
	}
	.u-img{
		padding-top: 10rpx;
		padding-bottom: 10rpx;
		padding-left: 10rpx;
		padding-right: 10rpx;
		width: 60rpx;
		height: 60rpx;
		border-radius: 7px;
		border: 6rpx solid #2c2c2c;
	}
	.u-txt{
		position: static;
		top: 0rpx;
		font-size: 25rpx;
		display: block;
	}

</style>
