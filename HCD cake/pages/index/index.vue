<template>
    <view class="page">
        <indextitle></indextitle>
        <pageswiper :imgList="swiperData" class="swiper"></pageswiper>
        <pagenav :navImage="navData"></pagenav>
        <pageline title="人气甜品"></pageline>
        <view class="g-limit">
            <view class="item-news" v-for="(item, index) in limitData" :key="item.mid">
                <image :src="item.pic" class="u-img" @click="gotoDetail(item)"></image>
                <view class="u-price1">￥{{ Math.ceil(item.price * 0.8) }}</view>
                <view class="u-price2">￥{{ item.price }}</view>
				<view class="u-txt">{{ item.mname }}</view>
                
                <view>
                    <text class="m-rest">剩余{{ item.num }}件</text>
                    <text class="m-buy">立即抢购</text>
                </view>
            </view>
        </view>
        <pageline title="常温小食"></pageline>
        <view class="g-newgoods">
            <view class="item-news" v-for="(item, index) in newData" :key="item.mid">
                <image :src="item.pic" class="u-img" @click="gotoDetail(item)"></image>
                <view class="u-price3">￥{{ item.price }}</view>
				<view class="u-txt">{{ item.mname }}</view>
                
            </view>
        </view>
        <pageline title="家的味道"></pageline>
        <view class="g-recomm">
            <view class="item-news" v-for="(item, index) in recommendData" :key="item.mid">
                <image :src="item.pic" class="u-img" @click="gotoDetail(item)"></image>
                <view>
                    <text class="b-txt">￥{{ item.price }}</text>
                </view>
				<view class="u-txt">{{ item.mname }}</view>
                
            </view>
        </view>
        <pagefab></pagefab>
        <pagescroller :scrollImg="scrollData"></pagescroller>
    </view>
</template>

<script>
export default {
    data() {
        return {
            swiperData: [
                { id: 1, pic: "/static/imgs_index/banner1.jpg" },
                { id: 2, pic: "/static/imgs_index/banner2.jpg" },
                { id: 3, pic: "/static/imgs_index/banner3.jpg" },
                { id: 4, pic: "/static/imgs_index/banner4.jpg" },
            ],
            navData: [
                { id: 1, txt: "蛋糕", pic: "/static/nav/icon_01.png" },
                { id: 2, txt: "甜品", pic: "/static/nav/icon_02.png" },
                { id: 3, txt: "饮品", pic: "/static/nav/icon_03.png" },
                { id: 4, txt: "常温小食", pic: "/static/nav/icon_04.png" },
                { id: 5, txt: "私房菜", pic: "/static/nav/icon_05.png" },
            ],
            scrollData: [
                { id: 1, pic: "/static/imgs_index/jinritejia1.jpg" },
                { id: 2, pic: "/static/imgs_index/jinritejia2.jpg" },
                { id: 3, pic: "/static/imgs_index/jinritejia3.jpg" },
                { id: 4, pic: "/static/imgs_index/jinritejia4.jpg" },
            ],
            limitData: [],
            newData: [],
            recommendData: []
        }
    },
    onLoad() {
        this.getData(1, "limitData");
        this.getData(2, "newData");
        this.getData(3, "recommendData");
    },
    methods: {
        getData(cid , nameData , pageSize = 3) {
            uni.request({
                url: "http://localhost:9998/menu/listcid?cid=" + cid,
                method: "get",
                success: (res) => {
                    let menuData = res.data.datas;
                    menuData.map((item) => {
                        item.pic = "/static/menu/" + item.pic;
                    })
                    this[nameData] = menuData;
                }
            })
        },
        gotoDetail(item) {
            uni.navigateTo({
                url: "/pages/goodsdetail/goodsdetail?item=" + JSON.stringify(item)
            })
        }
    }
}
</script>

<style scoped>
.page {
    background-color: #fff0f5;
}

.swiper {
    height: 700rpx; /* 调整高度 */
}

.g-limit, .g-newgoods, .g-recomm {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-between;
    background-color: #fff0f5;
    padding: 10rpx;
}

.item-news {
    width: 32%;
    margin-bottom: 10rpx;
    background-color: white;
    border-radius: 16rpx;
    overflow: hidden;
}

.u-img {
    width: 100%;
    height: 200rpx;
}

.u-txt, .u-price1, .u-price2, .u-price3, .b-txt {
    padding: 10rpx;
    font-size: 26rpx;
    color: #333;
}

.u-price1 {
    color: #ff69b4;
    font-weight: bold;
}

.u-price2 {
    text-decoration: line-through;
    color: #999;
}

.m-rest, .m-buy {
    font-size: 24rpx;
    margin: 0 5rpx;
}

.m-buy {
    background-color: #ff69b4;
    color: white;
    padding: 2rpx 5rpx;
    border-radius: 5rpx;
}
.u-price3,.b-txt{
	color: #ff69b4;
	font-size: 30rpx;
}
</style>
