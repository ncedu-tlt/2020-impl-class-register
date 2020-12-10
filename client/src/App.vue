<template>
  <div id="app" class="app">
    <HeaderComponent/>
    <div class="app__content">
      <router-view/>
    </div>
    <FooterComponent/>
  </div>
</template>

<script>
import HeaderComponent from "@/components/HeaderComponent";
import FooterComponent from "@/components/FooterComponent";

export default {
  name: 'App',
  components: {
    FooterComponent,
    HeaderComponent
  }
}
</script>

<style lang="less">
.app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  display: flex;
  flex-direction: column;
  min-height: 100vh;

  &__content {
    flex: 1 0 auto;
  }
}
</style>
