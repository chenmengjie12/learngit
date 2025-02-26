<template>
    <view>
        <scroll-view scroll-x="true" class="g-scroll">
            <view class="m-item" v-for="(item, index) in scrollImg" :key="item.id">
                <image :src="item.pic" class="u-img"></image>
            </view>
        </scroll-view>
    </view>
</template>

<script>
    export default {
        name: "pagescroller",
        props: ["scrollImg"],
        data() {
            return {
				
            };
        }
    }
</script>

<style scoped>
.g-scroll {
    display: flex;
    white-space: nowrap;
    margin-left: 10px;
    margin-right: 10px;
}

.m-item {
    width: 400rpx;
    height: 400rpx;
    display: inline-block;
    margin-right: 10rpx;
}

.u-img {
    width: 100%;
    height: 400rpx;
    border-radius: 30rpx;
}
</style>
