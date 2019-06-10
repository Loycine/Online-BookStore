<template>
  <div class="activity-slide-container">
    <div class="swiper-container" ref="activitySlide">
      <div class="swiper-wrapper">
        <div 
          class="swiper-slide"
          v-for="{title, image} of activities" 
          :key="title"
          >
          <a href="javascript:void(0)">
            <img :src="image">
          </a>
        </div>
      </div>
      <div class="swiper-pagination"></div>
      <div class="swiper-button-prev"></div>
      <div class="swiper-button-next"></div>
        </div>
  </div>
</template>

<script>
  import Swiper from 'swiper'
  import 'swiper/dist/css/swiper.min.css'

  export default {
    name: 'ActivitySlide',
    data () {
      return {
        activities: [
          {
            title: '低价星期二',
            image: 'http://image.read.duokan.com/mfsv2/download/fdsc3/p018tEwzlIIE/guWV59fgJ2hbim.jpg'
          },
          {
            title: '大裂',
            image: 'http://image.read.duokan.com/mfsv2/download/fdsc3/p01btQhhzKEP/uXSEtKJUVA4reR.jpg'
          },
          {
            title: '积极心理学特价',
            image: 'http://image.read.duokan.com/mfsv2/download/fdsc3/p01CJfj0T84u/mrHVknwyOGtg3C.jpg'
          }
        ]
      }
    },
    mounted () {
      new Swiper(this.$refs.activitySlide, {
        direction: 'horizontal',
        loop: true,
        autoplay: {
          delay: 2000
        },
        pagination: {
          el: '.swiper-pagination'
        },
        navigation: {
          nextEl: '.swiper-button-next',
          prevEl: '.swiper-button-prev'
        }
      });
    }
  }
</script>

<style lang="scss" scoped>
.activity-slide-container {
  width: 58%;
}

.swiper-container {
    width: 702px;
    height: 240px;
    margin: 0 auto;
}
</style>


