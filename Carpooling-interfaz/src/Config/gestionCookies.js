const gestionCookies = {
    getCookie: (name) => {
        // const cookie = document.cookie.match(new RegExp(name + '=([^;]+)'));
        // return cookie ? cookie[1] : null;
        return window.localStorage.getItem(name)
        },
        setCookie: (name, value, days) => {
            // var expires = "";
            // if (days) {
            //     var date = new Date();
            //     date.setTime(date.getTime() + (days * 24 * 60 * 60 *1000));
            //     expires = "; expires=" + date.toUTCString();
            // }
            // document.cookie = name + "=" + value + expires + "; path=/";
            window.localStorage.setItem(name,JSON.stringify(value))
            
        },
        
        deleteCookie: (name) => {
            // document.cookie = name + '=; expires=Thu, 01 Jan 1970 00:00:00 GMT; path=/';
            window.localStorage.removeItem(name)
            }

}