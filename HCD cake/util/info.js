export const isLogin=()=>{
	if(uni.getStorageSync("sanuser")){
		return true;
	}
	return false;
}
export const prompt=(title,icon)=>{
	uni.showToast({
		title,
		icon
	})
}
export const goPage=(url)=>{
	uni.navigateTo({
		url
	})
}