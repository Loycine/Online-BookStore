<template>
  <article
    class="user-login-window"
    v-show="openLoginPopupLayer">
    <header>
      <h3>登录</h3>
      <img 
        class="btn-close"
        @click.stop="closeLoginWindow"
        src="../assets/images/ic_close.png">
    </header>
    <form>
      <div>
        <label for="username">
          <input type="text" name="username" id="username" autofocus placeholder="用户名/手机号/邮箱">
        </label>
      </div>
      <div>
        <label for="password">
          <input type="password" name="password" placeholder="请输入密码">
        </label>
      </div>
      <div class="retri-pd">
        <a href="javascript:;">忘记密码?</a>
      </div>
      <div class="loginin">
        <button type="button" class="btn-loginin" @click.stop="loginAccount">登录</button>
      </div>
    </form>
    <footer>
      <p>
        <a class="sign-up" href="javascript:;">
          没有账号？免费注册 &gt;
        </a>
      </p>
    </footer>
  </article> 
</template>

<script>
  export default {
    name: 'UserLoginWindow',

    props: {
      openLoginPopupLayer: Boolean
    },
    
    methods: {
      loginAccount (loginInfo = null) {
        this.$emit('login', loginInfo);
      },
      closeLoginWindow() {
        this.loginAccount();
      }
    },

    mounted() {
      this.$nextTick(function() {
        document.addEventListener('click', function(event) {
          if (this.openLoginPopupLayer) {
            if (event.target !== this.$el) {
              this.closeLoginWindow();
            }
          }
        });
      });
    }
  }
</script>

<style lang="scss" scoped>
@import '../assets/styles/common';

.user-login-window {
  z-index: 2;
  position: fixed;
  top: 60vh;
  left: 50vw;
  width: 500px;
  border-radius: 1rem;
  transform: translate(-50%, -50%);
  background: #fff;
}

header {
  display: flex;
  align-items: center;
  background: #2280ef;
  padding: .3rem 1rem;
  h3 {
    color: #fff;
    font-size: 1.5rem;
  }
  .btn-close {
    margin-left: auto;
  }
}

form {
  width: 300px;
  margin: 0 auto;
  padding: 2rem;

  div {
    width: 250px;
    margin: 0 auto;
    padding: .2em 0;
  }

  .retri-pd {
    text-align: right;
  }

  .loginin {
    text-align: center;
  }

  input {
    width: 100%;
    padding: .5em;
    border: 1.5px solid #999;
    border-radius: .5em;
    background: transparent;
    font-size:1.0rem;

    &:focus {
      outline: none;
      border: 1px solid $site-primary-color;
    }
  }

  .retri-pd a,
  .sign-up {
    &:hover {
      text-decoration: underline;
    }
  }
  
  .btn-loginin {
    width: 100%;
    border-radius: .5em;
    padding: .5em 0;
    color: #fff;
    background: $site-primary-color;
    font-size:1.0em ;
    &:hover {
      cursor: pointer;
    }
  }
}

footer {
  border-top: 1px solid gray;
  padding: 1.0rem;
  text-align: right;
}
</style>


