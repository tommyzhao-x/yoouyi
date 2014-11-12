(function() {
    angular.module('travelWeb').controller('TravelWebController', ['$scope', '$http', '$location', '$routeParams', '$modal', function ($scope, $http, $location, $routeParams, $modal) {

        $scope.constants = {
            maxSize: 10,
            pageSize: 12,
            firstText: '首页',
            lastText: '末页',
            previousText: '上一页',
            nextText: '下一页',
            ignoreTest: '不限',
            IPAPI: 'api/ip',
            api: {
               signUp: 'api/user/signUp'
            },
            cities: [{city: '北京', id: 131}, {city: '天津', id: 332},
                     {city: '石家庄', id: 150}, {city: '唐山', id: 265}, {city: '秦皇岛', id: 148}, {city: '邯郸', id: 151}, {city: '邢台', id: 266},
                     {city: '保定', id: 307}, {city: '张家口', id: 264}, {city: '承德', id: 207}, {city: '沧州', id: 149}, {city: '廊坊', id: 191},
                     {city: '衡水', id: 208}, {city: '太原', id: 176}, {city: '大同', id: 355}, {city: '阳泉', id: 357}, {city: '长治', id: 356},
                     {city: '晋城', id: 290}, {city: '朔州', id: 237}, {city: '晋中', id: 238}, {city: '运城', id: 328}, {city: '忻州', id: 367},
                     {city: '临汾', id: 368}, {city: '吕梁', id: 327}, {city: '呼和浩特', id: 321}, {city: '包头', id: 229}, {city: '乌海', id: 123},
                     {city: '赤峰', id: 297}, {city: '通辽', id: 64}, {city: '鄂尔多斯', id: 283}, {city: '呼伦贝尔', id: 61}, {city: '巴彦淖尔', id: 169},
                     {city: '乌兰察布', id: 168}, {city: '兴安盟', id: 62}, {city: '锡林郭勒盟', id: 63}, {city: '阿拉善盟', id: 230}, {city: '沈阳', id: 58},
                     {city: '大连', id: 167}, {city: '鞍山', id: 320}, {city: '抚顺', id: 184}, {city: '本溪', id: 227}, {city: '丹东', id: 282},
                     {city: '锦州', id: 166}, {city: '营口', id: 281}, {city: '阜新', id: 59}, {city: '辽阳', id: 351}, {city: '盘锦', id: 228},
                     {city: '铁岭', id: 60}, {city: '朝阳', id: 280}, {city: '葫芦岛', id: 319}, {city: '长春', id: 53}, {city: '吉林市', id: 55},
                     {city: '四平', id: 56}, {city: '辽源', id: 183}, {city: '通化', id: 165}, {city: '白山', id: 57}, {city: '松原', id: 52},
                     {city: '白城', id: 51}, {city: '延边朝鲜族自治州', id: 54}, {city: '哈尔滨', id: 48}, {city: '齐齐哈尔', id: 41}, {city: '鸡西', id: 46},
                     {city: '鹤岗', id: 43}, {city: '双鸭山', id: 45}, {city: '大庆', id: 50}, {city: '伊春', id: 40}, {city: '佳木斯', id: 42},
                     {city: '七台河', id: 47}, {city: '牡丹江', id: 49}, {city: '黑河', id: 39}, {city: '绥化', id: 44}, {city: '大兴安岭地区', id: 38},
                     {city: '上海', id: 289}, {city: '南京', id: 315}, {city: '无锡', id: 317}, {city: '徐州', id: 316}, {city: '常州', id: 348},
                     {city: '苏州', id: 224}, {city: '南通', id: 161}, {city: '连云港', id: 347}, {city: '淮安', id: 162}, {city: '盐城', id: 223},
                     {city: '扬州', id: 346}, {city: '镇江', id: 160}, {city: '泰州', id: 276}, {city: '宿迁', id: 277}, {city: '杭州', id: 179},
                     {city: '宁波', id: 180}, {city: '温州', id: 178}, {city: '嘉兴', id: 334}, {city: '湖州', id: 294}, {city: '绍兴', id: 293},
                     {city: '金华', id: 333}, {city: '衢州', id: 243}, {city: '舟山', id: 245}, {city: '台州', id: 244}, {city: '丽水', id: 292},
                     {city: '合肥', id: 127}, {city: '芜湖', id: 129}, {city: '蚌埠', id: 126}, {city: '淮南', id: 250}, {city: '马鞍山', id: 358},
                     {city: '淮北', id: 253}, {city: '铜陵', id: 337}, {city: '安庆', id: 130}, {city: '黄山', id: 252}, {city: '滁州', id: 189},
                     {city: '阜阳', id: 128}, {city: '宿州', id: 370}, {city: '巢湖', id: 251}, {city: '六安', id: 298}, {city: '亳州', id: 188},
                     {city: '池州', id: 299}, {city: '宣城', id: 190}, {city: '福州', id: 300}, {city: '厦门', id: 194}, {city: '莆田', id: 195},
                     {city: '三明', id: 254}, {city: '泉州', id: 134}, {city: '漳州', id: 255}, {city: '南平', id: 133}, {city: '龙岩', id: 193},
                     {city: '宁德', id: 192}, {city: '南昌', id: 163}, {city: '景德镇', id: 225}, {city: '萍乡', id: 350}, {city: '九江', id: 349},
                     {city: '新余', id: 164}, {city: '鹰潭', id: 279}, {city: '赣州', id: 365}, {city: '吉安', id: 318}, {city: '宜春', id: 278},
                     {city: '抚州', id: 226}, {city: '上饶', id: 364}, {city: '济南', id: 288}, {city: '青岛', id: 236}, {city: '淄博', id: 354},
                     {city: '枣庄', id: 172}, {city: '东营', id: 174}, {city: '烟台', id: 326}, {city: '潍坊', id: 287}, {city: '济宁', id: 286},
                     {city: '泰安', id: 325}, {city: '威海', id: 175}, {city: '日照', id: 173}, {city: '莱芜', id: 124}, {city: '临沂', id: 234},
                     {city: '德州', id: 372}, {city: '聊城', id: 366}, {city: '滨州', id: 235}, {city: '菏泽', id: 353}, {city: '郑州', id: 268},
                     {city: '开封', id: 210}, {city: '洛阳', id: 153}, {city: '平顶山', id: 213}, {city: '安阳', id: 267}, {city: '鹤壁', id: 215},
                     {city: '新乡', id: 152}, {city: '焦作', id: 211}, {city: '濮阳', id: 209}, {city: '许昌', id: 155}, {city: '漯河', id: 344},
                     {city: '三门峡', id: 212}, {city: '南阳', id: 309}, {city: '商丘', id: 154}, {city: '信阳', id: 214}, {city: '周口', id: 308},
                     {city: '驻马店', id: 269}, {city: '武汉', id: 218}, {city: '黄石', id: 311}, {city: '十堰', id: 216}, {city: '宜昌', id: 270},
                     {city: '襄阳', id: 156}, {city: '鄂州', id: 122}, {city: '荆门', id: 217}, {city: '孝感', id: 310}, {city: '荆州', id: 157},
                     {city: '黄冈', id: 271}, {city: '咸宁', id: 362}, {city: '随州', id: 371}, {city: '恩施土家族苗族自治州', id: 373}, {city: '仙桃', id: 1713},
                     {city: '潜江', id: 1293}, {city: '天门', id: 2654}, {city: '神农架林区', id: 2734}, {city: '长沙', id: 158}, {city: '株洲', id: 222},
                     {city: '湘潭', id: 313}, {city: '衡阳', id: 159}, {city: '邵阳', id: 273}, {city: '岳阳', id: 220}, {city: '常德', id: 219},
                     {city: '张家界', id: 312}, {city: '益阳', id: 272}, {city: '郴州', id: 275}, {city: '永州', id: 314}, {city: '怀化', id: 363},
                     {city: '娄底', id: 221}, {city: '湘西土家族苗族自治州', id: 274}, {city: '广州', id: 257}, {city: '韶关', id: 137},
                     {city: '深圳', id: 340}, {city: '珠海', id: 140}, {city: '汕头', id: 303}, {city: '佛山', id: 138}, {city: '江门', id: 302},
                     {city: '湛江', id: 198}, {city: '茂名', id: 139}, {city: '肇庆', id: 338}, {city: '惠州', id: 301}, {city: '梅州', id: 141},
                     {city: '汕尾', id: 339}, {city: '河源', id: 200}, {city: '阳江', id: 199}, {city: '清远', id: 197}, {city: '东莞', id: 119},
                     {city: '中山', id: 187}, {city: '潮州', id: 201}, {city: '揭阳', id: 259}, {city: '云浮', id: 258}, {city: '南宁', id: 261},
                     {city: '柳州', id: 305}, {city: '桂林', id: 142}, {city: '梧州', id: 304}, {city: '北海', id: 295}, {city: '防城港', id: 204},
                     {city: '钦州', id: 145}, {city: '贵港', id: 341}, {city: '玉林', id: 361}, {city: '百色', id: 203}, {city: '贺州', id: 260},
                     {city: '河池', id: 143}, {city: '来宾', id: 202}, {city: '崇左', id: 144}, {city: '海口', id: 125}, {city: '三亚', id: 121},
                     {city: '五指山', id: 1644}, {city: '琼海', id: 2358}, {city: '儋州', id: 1215}, {city: '文昌', id: 2758}, {city: '万宁', id: 1216},
                     {city: '东方', id: 2634}, {city: '定安', id: 1214}, {city: '屯昌', id: 1641}, {city: '澄迈', id: 2757}, {city: '临高', id: 2033},
                     {city: '白沙黎族自治', id: 2359}, {city: '昌江黎族自治', id: 1642}, {city: '乐东黎族自治', id: 2032}, {city: '陵水黎族自治', id: 1643},
                     {city: '保亭黎族苗族自治', id: 1217}, {city: '琼中黎族苗族自治', id: 2031}, {city: '重庆', id: 132}, {city: '成都', id: 75},
                     {city: '自贡', id: 78}, {city: '攀枝花', id: 81}, {city: '泸州', id: 331}, {city: '德阳', id: 74}, {city: '绵阳', id: 240},
                     {city: '广元', id: 329}, {city: '遂宁', id: 330}, {city: '内江', id: 248}, {city: '乐山', id: 79}, {city: '南充', id: 291},
                     {city: '眉山', id: 77}, {city: '宜宾', id: 186}, {city: '广安', id: 241}, {city: '达州', id: 369}, {city: '雅安', id: 76},
                     {city: '巴中', id: 239}, {city: '资阳', id: 242}, {city: '阿坝藏族羌族自治州', id: 185}, {city: '甘孜藏族自治州', id: 73},
                     {city: '凉山彝族自治州', id: 80}, {city: '贵阳', id: 146}, {city: '六盘水', id: 147}, {city: '遵义', id: 262},
                     {city: '安顺', id: 263}, {city: '铜仁地区', id: 205}, {city: '黔西南布依族苗族自治州', id: 343}, {city: '毕节地区', id: 206},
                     {city: '黔东南苗族侗族自治州', id: 342}, {city: '黔南布依族苗族自治州', id: 306}, {city: '昆明', id: 104}, {city: '曲靖', id: 249},
                     {city: '玉溪', id: 106}, {city: '保山', id: 112}, {city: '昭通', id: 336}, {city: '丽江', id: 114}, {city: '临沧', id: 110},
                     {city: '楚雄彝族自治州', id: 105}, {city: '红河哈尼族彝族自治州', id: 107}, {city: '文山壮族苗族自治州', id: 177}, {city: '普洱', id: 108},
                     {city: '西双版纳傣族自治州', id: 109}, {city: '大理白族自治州', id: 111}, {city: '德宏傣族景颇族自治州', id: 116},
                     {city: '怒江傈僳族自治州', id: 113}, {city: '迪庆藏族自治州', id: 115}, {city: '拉萨', id: 100}, {city: '昌都地区', id: 99},
                     {city: '山南地区', id: 97}, {city: '日喀则地区', id: 102}, {city: '那曲地区', id: 101}, {city: '阿里地区', id: 103},
                     {city: '林芝地区', id: 98}, {city: '西安', id: 233}, {city: '铜川', id: 232}, {city: '宝鸡', id: 171}, {city: '咸阳', id: 323},
                     {city: '渭南', id: 170}, {city: '延安', id: 284}, {city: '汉中', id: 352}, {city: '榆林', id: 231}, {city: '安康', id: 324},
                     {city: '商洛', id: 285}, {city: '兰州', id: 36}, {city: '嘉峪关', id: 33}, {city: '金昌', id: 34}, {city: '白银', id: 35},
                     {city: '天水', id: 196}, {city: '武威', id: 118}, {city: '张掖', id: 117}, {city: '平凉', id: 359}, {city: '酒泉', id: 37},
                     {city: '庆阳', id: 135}, {city: '定西', id: 136}, {city: '陇南', id: 256}, {city: '临夏回族自治州', id: 182},
                     {city: '甘南藏族自治州', id: 247}, {city: '西宁', id: 66}, {city: '海东地区', id: 69}, {city: '海北藏族自治州', id: 67},
                     {city: '黄南藏族自治州', id: 70}, {city: '海南藏族自治州', id: 68}, {city: '果洛藏族自治州', id: 72}, {city: '玉树藏族自治州', id: 71},
                     {city: '海西蒙古族藏族自治州', id: 65}, {city: '银川', id: 360}, {city: '石嘴山', id: 335}, {city: '吴忠', id: 322},
                     {city: '固原', id: 246}, {city: '中卫', id: 181}, {city: '乌鲁木齐', id: 92}, {city: '克拉玛依', id: 95}, {city: '吐鲁番地区', id: 89},
                     {city: '哈密地区', id: 91}, {city: '昌吉回族自治州', id: 93}, {city: '博尔塔拉蒙古自治州', id: 88}, {city: '巴音郭楞蒙古自治州', id: 86},
                     {city: '阿克苏地区', id: 85}, {city: '克孜勒苏柯尔克孜自治州', id: 84}, {city: '喀什地区', id: 83}, {city: '和田地区', id: 82},
                     {city: '伊犁哈萨克自治州', id: 90}, {city: '塔城地区', id: 94}, {city: '阿勒泰地区', id: 96}, {city: '石河子', id: 770},
                     {city: '阿拉尔', id: 731}, {city: '图木舒克', id: 792}, {city: '五家渠', id: 789}, {city: '香港特别行政区', id: 2912},
                     {city: '澳门特别行政区', id: 2911}]
        
        };

        $scope.travelWeb = {

        };

        (function init() {

            getUserLocationByIp();



        }) ();
        
//        $scope.$on('onSearchItems', function (event, data) {
//            $scope.travelWeb = data;
//        });


        $scope.searchTravel = function () {
            $location.path($scope.generateTravelLink())
        };

        $scope.generateTravelLink = function () {

            return 'index/' + [$scope.travelWeb.starting, $scope.travelWeb.destination,
                $scope.travelWeb.selectedItinerary, $scope.travelWeb.selectedPlatform, $scope.travelWeb.selectedOrder].join('_');
        };


        $scope.parentlog = function () {

            console.log('parent log');

        };
        
        $scope.changeCity = function (city) {
            $scope.travelWeb.selectedCity = city;
            localStorage.setItem('cityCode', city.id);
            $scope.travelWeb.starting = $scope.travelWeb.selectedCity.city;
        };

        $scope.signIn = function () {

            console.log('sign in');
            var modalInstance = $modal.open({
                templateUrl: 'resources/views/sys-web/UserModal.html',
                controller: 'UserModalController',
                resolve: {
                    pageInfo: function () {
                        return {
                            title: '登录',
                            isLogin: true
                        };
                    }
                }
            });

            modalInstance.result.then(function (user) {
                console.log(user);
            }, function () {
                console.log('no Modal dismissed at: ' + new Date());
            });
        };

        $scope.signUp = function () {

            console.log('sign in');
            var modalInstance = $modal.open({
                templateUrl: 'resources/views/sys-web/UserModal.html',
                controller: 'UserModalController',
                resolve: {
                    pageInfo: function () {
                        return {
                            title: '注册'
                        };
                    }
                }
            });

            modalInstance.result.then(function (user) {
                console.log(user,  new Date());

                $http({method: 'post', url: $scope.constants.api.signUp, data: user})
                .success(function(data, status) {
                    if (data.success) {
                        $scope.userAdd.formData = {};
                    }
                })
            });
        };

        function getUserLocationByIp() {
            var localStorage = window.localStorage;
            var cityCode = localStorage.getItem('cityCode');
            if (!cityCode) {
                
                var myCity = new BMap.LocalCity();
                myCity.get(function (result) {
                    console.log(result);

                    localStorage.setItem('cityCode', result.code);

                    $scope.$apply(function () {
                        $scope.travelWeb.selectedCity = _.findWhere($scope.constants.cities, {id: result.code});
                        $scope.travelWeb.starting = $scope.travelWeb.selectedCity.city;
                    });
                });

            } else {
                console.log(cityCode);
                $scope.travelWeb.selectedCity = _.findWhere($scope.constants.cities, {id: Number(cityCode)});
                $scope.travelWeb.starting = $scope.travelWeb.selectedCity.city;
            }
        }


    }]);
})();