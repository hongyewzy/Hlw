new Vue({
    el: "#app",
    data: {
        dataList: [],
        feng1: true,
        feng2: true,
        deng: true,
    },
    created() {
        this.basexx();//由硬件发过来，判断最初的器材的状态
        this.getAll();
    },

    methods: {
        basexx() {
            var paramStr = "?test=" + "hh"
                + "#feng1=" + this.feng1
                + "#feng2=" + this.feng2
                + "#deng=" + this.deng;
            axios({
                    url: '/ny/basexx/' + paramStr,
                    method: 'get',
                }
            ).then((res) => {
                console.log("最初的数据为：{}",res.data);
            })


        },

        getAll() {
            axios({//农场数据
                    url: '/ny',
                    method: 'get',
                }
            ).then((res) => {
                console.log("我的nydata的数据为:   ",res.data);
                this.dataList = res.data.data;
            })

            axios({//器具数据
                    url: '/supplies',
                    method: 'get',
                }
            ).then((res) => {
                console.log("我的supplies的数据为：",res.data);
                // if(res.data.data.feng1=="1") this.feng1=1;
                // else this.feng1=false;
                // if(res.data.data.feng2=="1") this.feng2=true;
                // else this.feng2=false;
                if(res.data.data.deng=="1") this.deng=true;
                else this.deng=false;

                this.feng1=res.data.data.feng1;
                this.feng2=res.data.data.feng2;

            })

        },

        changefeng1() {
            var paramStr = "?test=" + "hh"
                + "&feng1=" + this.feng1;//在这里时this.feng1已经改变了,因为点击了才会进入到这个方法啊,
            console.log("这是fneg1的：" + this.feng1);
            axios({
                    url: '/ny/feng1/' + paramStr,
                    method: 'get',
                }
            ).then((res) => {

            })
        },

        changedeng() {
            var paramStr = "?test" + "hh"
                + "&deng=" + this.deng;
            axios({
                    url: '/ny/deng/' + paramStr,
                    method: 'get',
                }
            ).then((res) => {

            })
        },

        changefeng2() {
            var paramStr = "?test" + "hh"
                + "&feng2=" + this.feng2;
            axios({
                    url: '/ny/feng2/' + paramStr,
                    method: 'get',
                }
            ).then((res) => {

            })
        },

    }


})

// //获取url地址上面的参数
// function requestUrlParam(argname) {
//     var url = location.href
//     var arrStr = url.substring(url.indexOf("?") + 1).split("&")
//     for (var i = 0; i < arrStr.length; i++) {
//         var loc = arrStr[i].indexOf(argname + "=")
//         if (loc != -1) {
//             return arrStr[i].replace(argname + "=", "").replace("?", "")
//         }
//     }
//     return ""
// }


// axios({//器具数据
//         url: '/supplies',
//         method: 'get',
//     }
// ).then((res) => {
//     console.log("器具的数据是:{}",res);
//     this.feng1=res.data.data.feng1;
//     this.feng2=res.data.data.feng2;
//     this.deng=res.data.data.deng;
// })
