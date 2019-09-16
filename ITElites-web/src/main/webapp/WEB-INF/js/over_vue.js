/**
 * 思路：
 * 1. 首先要把图片都放进一个对象中并且遍历出来
 * 2. 使用v-if v-else控制常态与hover时图片的展示情况
 * 3. 定义一个active获取下标，来展示列表中对应的hover状态
 *
 */
// 概况侧边栏（小组介绍）
new Vue({
    el: "#Aside",
    data: {
      active: 0, // 是否是hover状态
          isHover: false, // 是否只移出不移入
      check: 0, //是否是选中状态
      iconLists: [
        {
          title: "I T培优",
          icon: "static/p1.png",
          icon_hover: "static/p1r.png"
        },
        {
          title: "编程组",
          icon: "static/p2.png",
          icon_hover: "static/p2r.png"
        },
        {
          title: "美工组",
          icon: "static/p3.png",
          icon_hover: "static/p3r.png"
        },
        {
          title: "产品组",
          icon: "static/p4.png",
          icon_hover: "static/p4r.png"
        },
        {
          title: "教师技能组",
          icon: "static/p5.png",
          icon_hover: "static/p5r.png"
        },
        {
          title: "新媒体组",
          icon: "static/p6.png",
          icon_hover: "static/p6r.png"
        }
      ]
    },
    methods: {
      asideId: function(index) {   // 侧边栏元素动态分配id
        var Num = index + 1;
        return "aside" + Num;
      },
      mouseOver: function(index) {
              this.isHover = true;
        this.active = index;
      },
          mouseLeave: function(index){
              this.isHover = false;
          },
      checked: function(index) {
        this.check = index;
      }
    }
  });

  new Vue({
    el: "#groupIntroduce",
    data: {
      ProgrammingGroups: [
        {
          name: "ACM 组",
          introduce: "该组以算法为核心，致力参加各类算法竞赛，提高创新能力、团队精神和在压力下编写程序、分析和解决问题能力。,\
          主要使用c/c++进行编程，利用好的算法提升自己的编程能力。该组知识与软件工程、计算机科学与技术、网络工程专业联系较为紧密\
          ，欢迎喜欢研究算法，喜欢参加竞赛的同学加入。"
        },
        {
          name: "嵌入式组",
          introduce: "该组主要对嵌入式系统进行学习与研究，集软件与硬件与一体，同时拥有软件和硬件的特点，如C语言，汇编语言，数据结构，,\
          模拟电路，数字电路，单片机等。通过参与智能小车，机器人，飞行器等实际操作作为技能提升练习，并能够主动参与一些嵌入式赛事来提升自我\
          能力。该组知识与计算机科学与技术专业联系较为紧密，欢迎喜欢硬件，喜欢着手将自己的想法变为现实，对嵌入式感兴趣的同学加入。"
        },
        {
          name: "信息安全组",
          introduce: "该组主要研究现代化信息与网络的安全问题，包含网站安全、网络安全、主机安全、数据库安全等，学习内容涉及计算机科学、网络,\
          技术、通信技术、密码技术、信息安全技术、数论、心理学等多种学科。学习分为渗透、编程、逆向三个方向。该组知识与网络工程、计算机科学与\
          技术、软件工程专业联系较为紧密，欢迎喜欢研究信息安全的同学加入"
        },
        {
          name: "Web 前端组",
          introduce: "该组主要学习目标是进行客户端、移动端等方向的前端开发和相应网页开发语言如HTML、CSS、JavaScript、node.js的学习。内容\
          涉及网站、APP页面的实现与优化，以及熟练运用框架辅助开发，同时需了解Web服务器和前后端交互相关知识。该组知识与网络工程、软件工程、计\
          算机科学与技术专业联系较为紧密，欢迎对前端开发感兴趣的同学加入。"
        },
        {
          name: "Swift 组",
          introduce: "该组以苹果平台为基础，学习iphone、ipad、itouch和imac等IOS移动终端的应用和游戏开发。通过object-c、Swift编程语言设计\
          更加有针对性、画面感更强的游戏。该组知识与软件工程、计算机科学与技术、网络工程专业联系较为紧密，欢迎对IOS操作系统感兴趣的同学加入。"
        },
        {
          name: "C++ 组",
          introduce: "(敬请期待)"
        },
        {
          name: "C# 组",
          introduce: "该组以微软公司C#编程语言为核心，主要研究方向是各类管理系统和服务平台的开发，也在程序开发，游戏编写方面有研究。asp.net\
          开发，C#编程基础，Visual Studio使用都是本组必修课。本组与计算机科学与技术，软件工程，网络工程专业联系较多，欢迎热爱C#编程的同学加入。"
        },
        {
          name: "Java 组",
          introduce: "该组内部有两个方向，分别是Android方向和Java Web方向。Java组以Java语言为基础，学习安卓平台上的应用游戏开发。通过xml灵活\
          地设计UI，使得UI更加优越，通过JAVA更加简便地设计应用功能，使得功能更加强大。同时eclipse和android studio是该组必要工具。该组知识与\
          软件工程、网络工程、计算机科学与技术联系较多，欢迎热爱Java编程，热爱安卓开发的同学加入。"
        },
        {
          name: "Python 组",
          introduce: "(敬请期待)"
        }
      ],
  
      ArtGroups: [
        {
          name: "平面设计组",
          introduce: "学会给图片加上一些特效，同时会以设计海报、宣传单、网站设计等为主要练习对象，后期设计UI（如手机软件界面）、\
          VI（包括海报、书籍装帧、名片等）设计。当前阶段主要使用工具软件有Photoshop，学习软件的目的是让成员能够熟练掌握软件基本的操作和各种工具的使用，\
          并能够使用软件做简单的图像处理。平面设计小组与编程组会有较多的合作，同时与视频组也会有密切的联系。欢迎喜欢修图、想要做设计方面的同学加入。"
        },
        {
          name: "影视编辑组",
          introduce: "以创新为主，学习前期（相机和摄像机的使用和拍摄手法）和后期（PR、AE、MAYA的使用方法和技巧），该组与教育技术专业联系较多，\
          同时欢迎热爱影视编辑的同学加入。"
        }
      ]
    },
    methods: {
      programmingGroupId: function(index) {
        var Num = index + 1;
        return "PgroupId" + Num;
      },
      ArtGroupId: function(index) {
        var Num = index + 1;
        return "RgroupId" + Num;
      },
      getWidth: function() {
        var len = this.ArtGroups.length;
        var Width = 100/(len+1);
        return 'width:'+ Width + '%';
      }   //动态改变组介绍手风琴样式的宽
    }
  });