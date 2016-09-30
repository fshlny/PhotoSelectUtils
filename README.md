#PhotoSeletUtils

对调用系统相机拍照和系统相册获取图片的方法进行分装。

##PhotoSelectUtils的使用
如果不需要指定拍照后图片存放目录，可以使用以下初始化方法
```
	//activity context对象
	//boolean false 是否需要裁剪图片
	//PhotoCallback callback 回调
  	api = new PhotoSelectUtils(activity,false,callback);
```
如果需要将拍照后的图片存放到指定目录，可以使用一下方法初始化
```
	//activity context对象
	//boolean false 是否需要裁剪图片
	//String dir 保存图片的目录
	//PhotoCallback callback 回调
  	PhotoSelectUtils(Activity activity,boolean isCrop,String dir,PhotoCallback callback)
```
重写onActivityResult方法
```
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        api.onResult(requestCode,resultCode,data);
    }
```
获取图片

```
	api.getPhoto();
```
最后在AndroidManifest加入文件读写的权限