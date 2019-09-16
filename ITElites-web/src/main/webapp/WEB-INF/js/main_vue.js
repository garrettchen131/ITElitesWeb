
/* 主页轮播图数据 */
new Vue({
  el: "#LunBo",
  data: {
    slideList: [
      "./static/bgimg1.jpg",
      "./static/bgimg2.jpg",
      "./static/bgimg3.jpg",
      "./static/bgimg4.jpg",
      "./static/bgimg5.jpg"
    ],
    currentIndex: 0,
    timer: ""
  },
  created() {
    // dom加载后下一个tick开始轮播
    this.$nextTick(() => {
      this.timer = setInterval(() => {
        this.currentIndex++;
        if (this.currentIndex > this.slideList.length - 1) {
          this.currentIndex = 0;
        }
      }, 10000);
    });
  },
  methods: {
    change(index) {
      this.currentIndex = index;
    }
  }
});

// 主页成果展展示框数据
new Vue({
  el: "#achievements",
  data: {
    numbers: [    
      {
        img: "static/test.png",
        title: "第一届",
      },
      {
        img: "static/test.png",
        title: "第二届",
      },
      {
        img: "static/test.png",
        title: "第三届",
      },
      {
        img: "static/test.png",
        title: "第四届",
      }
    ]
  },
  methods: {
    achievementsId: function(index) {   // 成果展展示框动态分配id
      var Num = index + 1;
      return "introduceId" + Num;
    }
  }
});



