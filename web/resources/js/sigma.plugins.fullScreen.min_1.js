(function(a){"use strict";function b(){document.fullscreenElement||document.mozFullScreenElement||document.webkitFullscreenElement||document.msFullscreenElement?document.exitFullscreen?document.exitFullscreen():document.msExitFullscreen?document.msExitFullscreen():document.mozCancelFullScreen?document.mozCancelFullScreen():document.webkitExitFullscreen&&document.webkitExitFullscreen():d.requestFullscreen?d.requestFullscreen():d.msRequestFullscreen?d.msRequestFullscreen():d.mozRequestFullScreen?d.mozRequestFullScreen():d.webkitRequestFullscreen&&d.webkitRequestFullscreen(Element.ALLOW_KEYBOARD_INPUT)}function c(a){var c=a||{};d=c.container?"object"==typeof c.container?c.container:document.getElementById(c.container):this.container,e=null,c.btnId?(e=document.getElementById(c.btnId),e.removeEventListener("click",b),e.addEventListener("click",b)):b()}if("undefined"==typeof sigma)throw"sigma is not declared";sigma.utils.pkg("sigma.plugins.fullScreen");var d=null,e=null;sigma.plugins.fullScreen=c}).call(this);
//# sourceMappingURL=sigma.plugins.fullScreen.min.js.map