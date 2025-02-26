<template>
  <view class="container">
    <!-- 悬浮购物车按钮 -->
    <view class="floating-cart" @click="goToCart()">
      <uni-icons type="cart" size="30"></uni-icons>
    </view>
  </view>
</template>

<script>
export default {
  methods: {
    goToCart() {
      // 跳转到购物车页面
      uni.switchTab({
        url: '/pages/carts/carts', // 替换为你的购物车页面路径
      });
    },
  },
};
</script>

<style>
/* 页面整体样式 */
.container {
  position: absolute;
  width: 100%;
  /* height : 100vh;*/
  background-color: #f5f5f5;
}

.content {
  padding: 16px;
}

/* 悬浮购物车按钮样式 */
.floating-cart {
  position: fixed;
  bottom: 55px;
  right: 20px;
  width: 60px;
  height: 60px;
  background-color: white;
  border-radius: 50%;
  display: flex;
  justify-content: center;
  align-items: center;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
  z-index: 1000;
  cursor: pointer;
  transition: transform 0.2s ease, box-shadow 0.2s ease;
}

.floating-cart:hover {
  transform: scale(1.1);
  box-shadow: 0 6px 12px rgba(0, 0, 0, 0.3);
}

.cart-icon {
  font-size: 24px;
  color: #fff;
}
</style>