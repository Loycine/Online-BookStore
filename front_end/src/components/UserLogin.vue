<template>
  <section class="user-login-container">
    <h3 class="title">
      欢迎进入SHARP在线书店
    </h3>
    <img v-bind:src="scutImgUrl" width="30%">
    <br>
		<p class="welcome">登录在线书店，购买你喜欢的书籍</p>
    <br>
		<button 
      class="btn-into-login" 
      @click.stop="enterLoginPopupLayer">
        {{ loginText }} 
    </button>
    <user-login-window
      v-show="openLoginPopupLayer"
      @login="loginAccount">
    </user-login-window>
  </section>
</template>

<script>
  import UserLoginWindow from '@/components/UserLoginWindow'

  export default {
    name: 'UserLogin',
    components: {
      UserLoginWindow
    },
    data () {
      return {
        loginState: false,
        openLoginPopupLayer: false,
        scutImgUrl:require("../assets/images/scut.png")
      }
    },

    computed: {
      loginText() {
        return this.loginState?'退出':'登录';
      }
    },

    methods: {
      enterLoginPopupLayer () {
        if (this.loginState) {
          this.loginState = !this.loginState;
        } else {
          this.openLoginPopupLayer = true;
        }
      },
      loginAccount (loginInfo) {
        this.openLoginPopupLayer = false;
        if (loginInfo) {
          this.loginState = true;
        }
      }
    }
  }
</script>

<style lang="scss" scoped>
@import '../assets/styles/common';

.user-login-container {
  width: 30%;
  display: flex;
  flex-direction: column;
  padding: .4rem;
  display: table-cell;
  text-align: center;
}

.welcome {
  line-height: 1.5;
  font-size: .8rem;
}

.btn-into-login {
  border: none;
  width: 75%;
  border-radius: 10px;
  padding: .5rem;
  margin-top: auto;
  font-size: 1.5rem;
  background: #92c3c7;
  &:hover {
    color: rgb(19,1,1);
    //background: $site-primary-color;
    background: #07e036;
  }
  &:focus {
    outline: none;
  }
}
</style>


