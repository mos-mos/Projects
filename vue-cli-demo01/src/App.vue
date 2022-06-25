<template>
  <div id="app">
    <img src="./assets/logo.png">
    <HelloWorld/>
    <span><router-link to="/login">登录</router-link></span>
    <span><router-link to="/register">注册</router-link></span>
    <hr>
    <dic>
      <router-view></router-view>
    </dic>
<!--    <login/>-->
<!--    <hr/>-->
<!--    <register/>-->

  </div>
</template>

<script>

import HelloWorld from './components/HelloWorld'

export default {
  name: 'App',
  components: {
    // Register,
    // Login,
    // HelloWorld
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
