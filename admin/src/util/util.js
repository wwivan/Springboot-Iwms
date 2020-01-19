export function emailCheck(email) {
  var emailreg = /^([a-zA-Z0-9]+[_|.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
  if (!emailreg.test(email)) {
    return false;
  }
  return true;
}
export function pwdCheck(pwd) {
  var pwdreg = /^[a-zA-Z]\w{5,17}$/;
  if (!pwdreg.test(pwd)) {
    return false;
  }
  return true;
}
export function phoneNumCheck(phoneNUm) {
  var phoneNumreg = /^[1][3,4,5,7,8][0-9]{9}$/;
  if (!phoneNumreg.test(phoneNUm)) {
    return false;
  }
  return true;
}
export function stringCheck(string) {
  var result = removeSpace(string);
  if (result.length === 0) {
    return false;
  }
  return true;
}

function removeSpace(string) {
  var result;
  result = string.trim();
  result = result.replace(/\s/g, "");
  return result;
}

export function timeFormat(time) {
  let date = new Date(time);
  let month = date.getMonth() + 1;
  let day = date.getDay();
  let hour = date.getHours();
  let minutes = date.getMinutes();
  let str = `${month}-${day} ${hour}:${minutes}`;
  return str;
}

export const formatStockInStatus = function(num) {
  switch (num) {
    case 0:
    case "0":
      return "收货";
    case 1:
    case "1":
      return "理货中";
    case 2:
    case "2":
      return "理货完成";
    case 3:
    case "3":
      return "上架中";
    case 4:
    case "4":
      return "上架完成";
  }
};

export const formatStockOutStatus = function(num) {
  switch (num) {
    case 1:
    case "1":
      return "准备出库";
    case 2:
    case "2":
      return "配货中";
    case 3:
    case "3":
      return "配货完成";
    case 4:
    case "4":
      return "拣货中";
    case 5:
    case "5":
      return "拣货完成";
  }
};

export const formatStockTakeStatus = function(num) {
  switch (num) {
    case 1:
    case "1":
      return "初始";
    case 2:
    case "2":
      return "完成盘点待审核";
    case 3:
    case "3":
      return "完成盘点已审核";
    case 4:
    case "4":
      return "保存盘点";
    case 0:
    case "0":
      return "驳回";
  }
};

export const formatNextStockInStatus = function(num) {
  switch (num) {
    case 1:
    case "1":
      return "验收";
    case 2:
    case "2":
      return "--";
    case 3:
    case "3":
      return "--";
    case 4:
    case "4":
      return "上架";
    case 5:
    case "5":
      return "--";
    case 6:
    case "6":
      return "完成";
  }
};

export const formatStockInType = function(num) {
  switch (num) {
    case 1:
    case "1":
      return "一般采购入库";
    case 2:
    case "2":
      return "退货入库";
    case 3:
    case "3":
      return "内部生产入库";
    case 4:
    case "4":
      return "取消订单入库";
  }
};
//日期转变为时间戳
export const dateToTime = value => {
  const date = new Date(value);
  const str = date.getTime();
  return str / 1000;
};
//时间戳转变为日期
export const timeToDate = value => {
  var d = new Date(value * 1000); //时间戳记得乘以1000再进行处理
  var year = d.getFullYear();
  var month = d.getMonth() + 1;
  var date = d.getDate();
  var hour = d.getHours();
  var minute = d.getMinutes();
  var second = d.getSeconds();
  return (
    year + "-" + month + "-" + date + " " + hour + ":" + minute + ":" + second
  );
};
/**
 * 存储localStorage
 */
export const setStore = (name, content) => {
  if (!name) return;
  if (typeof content !== "string") {
    content = JSON.stringify(content);
  }
  window.localStorage.setItem(name, content);
};

/**
 * 获取localStorage
 */
export const getStore = name => {
  if (!name) return;
  return window.localStorage.getItem(name);
};

/**
 * 设置cookie
 */
export function setCookie(key, value) {
  var exdate = new Date(); //获取时间
  exdate.setTime(exdate.getTime() + 24 * 60 * 60 * 1000 * 365); //保存的天数，我这里写的是1年
  //字符串拼接cookie
  window.document.cookie =
    key + "=" + value + ";path=/;expires=" + exdate.toGMTString();
}

/**
 * 读取cookie
 */
export function getCookie(param) {
  var c_param = "";
  if (document.cookie.length > 0) {
    var arr = document.cookie.split("; "); //这里显示的格式需要切割一下自己可输出看下
    for (var i = 0; i < arr.length; i++) {
      var arr2 = arr[i].split("="); //再次切割
      //判断查找相对应的值
      if (arr2[0] == param) {
        c_param = arr2[1];
        //保存到保存数据的地方
      }
    }
    return c_param;
  }
}

/**
 * 删除localStorage
 */
export const removeStore = name => {
  if (!name) return;
  window.localStorage.removeItem(name);
};

/**
 * 格式化金额, 将分格式化为元</br>
 * eg: 1000 -> 1.00
 */
export const formatFen2Yuan = function(num) {
  if (num === undefined) {
    return "0.00";
  }
  // eslint-disable-next-line no-useless-escape
  num = num.toString().replace(/\$|\,/g, "");
  if (isNaN(num)) {
    return num;
  }
  num = num / 1000;
  let sign = num === (num = Math.abs(num));
  num = Math.floor(num * 100 + 0.50000000001);
  let cents = num % 100;
  num = Math.floor(num / 100).toString();
  if (cents < 10) {
    cents = "0" + cents;
  }
  for (let i = 0; i < Math.floor((num.length - (1 + i)) / 3); i++) {
    num =
      num.substring(0, num.length - (4 * i + 3)) +
      "," +
      num.substring(num.length - (4 * i + 3));
  }
  return (sign ? "" : "-") + num + "." + cents;
};
