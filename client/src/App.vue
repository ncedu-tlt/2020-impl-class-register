<template>
  <div id="app">

    <NavBar/>

    <div class="container">
      <router-view/>
    </div>

  </div>
</template>

<script>
import NavBar from "@/views/NavBar";
export default {
  components: {NavBar},
};
</script>
