<template>
  <view class="page">
    <indextitle></indextitle>
    <pagesearch></pagesearch>
    <view class="container">
      <view class="sidebar">
        <view 
          v-for="(category, index) in categories" 
          :key="index" 
          @click="selectCategory(index, category.cid)"
          :class="['category-item', { active: selectedCategory && selectedCategory.cid === category.cid }]"
        >
          {{ category.name }}
        </view>
      </view>
      <view class="content">
        <view v-if="selectedCategory">
          <view v-for="item in selectedCategory.items" :key="item.id" class="item">
            <image :src="item.pic" class="item-image" @click="gotoDetail(item)"/>
            <view class="item-details">
              <text class="item-name">{{ item.mname }}</text>
              <text class="item-price">￥{{ Math.ceil(item.price * 0.8) }}</text>
            </view>  
          </view>
        </view>
      </view>
    </view>
  </view>
</template>

<script>
export default {
  data() {
    return {
      categories: [
        { name: '蛋糕', cid: 1, items: [] },
        { name: '甜品', cid: 2, items: [] },
        { name: '饮品', cid: 3, items: [] },
        { name: '常温小食', cid: 4, items: [] },
        { name: '私房菜', cid: 5, items: [] },
      ],
      selectedCategory: null,
    };
  },
  mounted() {
    this.selectCategory(0);
  },
  methods: {
    selectCategory(index) {
      const category = this.categories[index];
      this.selectedCategory = category;
      if (category.items.length === 0) {
        this.getData(category.cid, index);
      }
    },
    getData(cid, index) {
      uni.request({
        url: "http://localhost:9998/menu/listcid?cid=" + cid,
        method: "get",
        success: (res) => {
          const menuData = res.data.datas;
          menuData.forEach((item) => {
            item.pic = "/static/menu/" + item.pic;
          });
          this.categories[index].items = menuData;
        }
      });
    },
    gotoDetail(item) {
      uni.navigateTo({
        url: "/pages/goodsdetail/goodsdetail?item=" + JSON.stringify(item)
      });
    }
  }
};
</script>

<style scoped>
.page {
  background-color: #fff0f5; /* 淡粉色背景 */
  height: 100vh;
}

.container {
  display: flex;
  height: 100%;
}

.sidebar {
  width: 120px;
  background-color: #f8f8f8;
  box-sizing: border-box;
  border-right: 1px solid #ddd;
}

.category-item {
  padding: 20px;

  cursor: pointer;
  text-align: center;
  transition: background-color 0.3s, color 0.3s;
  border-radius: 5px;
}

.category-item.active, .category-item:hover {
  background-color: #ffc0cb;
  color: #fff;
}

.content {
  flex: 1;
  padding: 20px;
  box-sizing: border-box;
  overflow-y: auto;
}

.item {
  display: flex;
  align-items: center;
  margin-bottom: 15px;
  padding: 10px;
  border-radius: 8px;
  transition: box-shadow 0.3s;
  background-color: #fff;
}

.item:hover {
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.item-image {
  width: 80px;
  height: 80px;
  border-radius: 10px;
  margin-right: 15px;
}

.item-details {
  display: flex;
  flex-direction: column;
}

.item-name {
  font-size: 18px;
  font-weight: bold;
  color: #555;
}

.item-price {
  font-size: 16px;
  color:#ff69b4;
  margin-top: 5px;
}
</style>
