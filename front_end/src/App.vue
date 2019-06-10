<template>
  <div id="app">
    <div class="main">
      <header-page></header-page>
      <nav-page></nav-page>
      <router-view></router-view>
      <site-footer></site-footer>
    </div>
    <sidebar-controls></sidebar-controls>
  </div>
</template>

<script>
  import HeaderPage from '@/components/HeaderPage'
  import NavPage from '@/components/NavPage'
  import SiteFooter from '@/components/SiteFooter'
  import SidebarControls from '@/components/SidebarControls'
  import {mapActions} from 'vuex'

  export default {
    name: 'App',
    components: {
      HeaderPage,
      NavPage,
      SiteFooter,
      SidebarControls
    },
    methods: {
      ...mapActions(['fetchTopics', 'fetchCategories'])
    },
    mounted () {
      this.$nextTick(function() {
        this.fetchTopics('./static/data/topic.json');
        this.fetchCategories('./static/data/category.json');
      });
    }
  }
</script>

<style lang="scss">
@import './assets/styles/reset';

.main {
  width: 1200px;
  margin: 0 auto;
}
</style>





