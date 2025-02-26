<template>
    <swiper class="swiper-pane" circular :indicator-dots="true" :autoplay="true" :interval="4000">
        <swiper-item v-for="(item, index) in imgList" :key="index">
            <image :src="item.pic" mode="aspectFill" class="u-img"></image>
        </swiper-item>
    </swiper>
</template>

<script>
    export default {
        name: "pageswiper",
        props: ["imgList"],
        data() {
            return {
                
            };
        }
    }
</script>

<style scoped>
.swiper-pane {
    height: 900rpx;
}

.u-img {
    width: 100%;
    height: 100%;
}
</style>

