// 顶部导航栏内容数据
new Vue({
  el: "#nav",
  data: {
    navLists: [
      {
        name: "首页",
        url: "index.html"
      },
      {
        name: "概况",
        url: "over.html"
      },
      {
        name: "招新",
        url: ""
      },
      {
        name: "培训",
        url: ""
      },
      {
        name: "公告",
        url: ""
      },
      {
        name: "疑难解答",
        url: ""
      }

    ],
    subpage: "index.html"
  },
  created() {
    /**
     *
     * 步骤：
     * 1. 先获取 最后一个 / 后面的文件名，this.subpage 变量
     * 2. 修改navLists，并循环渲染到a标签上
     * 3.  :class="subpage === navList.url ? 'active' : ''"
     *
     * 提醒：
     *    之后上线到服务器上，要注意几个导航页面的文件路径，要在同一目录下
     */
    const url = window.location.href;
    const index = url.lastIndexOf("/");
    this.subpage = url.substring(index + 1, url.length);
  },
  methods: {
    navsId: function(index) {
      // 顶部导航栏动态分配id
      var Num = index + 1;
      return "navList" + Num;
    },
    get:function(){
      //发送get请求
      this.$http.get('/gethead.do').then(function(res){
          document.write(res.body);       //成功
      },function(){
          console.log('请求失败处理');     //失败
      });
    }
  }
});
//搜索框
new Vue({
  el: "#search",
  data: {
    check: false,
    show: false
  },
});