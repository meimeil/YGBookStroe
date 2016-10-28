# hello-world
spring+struts2+hibernate3,tomcat,+maven. Website  ---- shopstroe 
首页，按销量，按上架时间，按优惠图书列出：
![image](https://github.com/meimeil/hello-world/raw/master/images-folder/firstpage.png)
导航头部页面，按出版社输入字符模糊查询：
![image](https://github.com/meimeil/hello-world/raw/master/images-folder/search1.jpg)
购物车页面，用session保存书bean，页面加载迭代出：
![image](https://github.com/meimeil/hello-world/raw/master/images-folder/cart.jpg)
订单页面，未实现付款，只是在管理员页面处理订单
![image](https://github.com/meimeil/hello-world/raw/master/images-folder/order.jpg)
管理订单界面：
![image](https://github.com/meimeil/hello-world/raw/master/images-folder/manageOrder.jpg)
管理员修改图书信息界面：
![image](https://github.com/meimeil/hello-world/raw/master/images-folder/modifyBook.jpg)

还实现了过滤未登陆管理员时对管理页面的访问。
拦截了未用户登陆时，对购物车，订单页面的访问。
