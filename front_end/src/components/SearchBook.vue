<template>
  <section class="search-book-container">
    <form>
      <input 
        type="search" 
        v-model.trim="keyword" 
        @input="searchBooks(keyword)" 
        :size="searckBoxSize" 
        :placeholder="placeholder"
      >
    </form>
    <ul class="matching-books" v-show="isShow">
      <li 
        class="matching-book-item"
        v-for="{id, images, title, author} of
        matchingBooks"
        @click="hideMatchingBooks" 
        :key="id"
        >
        <router-link 
          class="nav-link-book"
          :to="{name: 'Book', params: {id: id}}"
          >
          <section class="book-wraper">
            <img class="book-image" v-bind:src="images.small">
            <div class="book-info">
              <h4 class="title"> {{ title }} </h4>
              <p class="author"> {{ author.join(',') }} </p>
            </div>
          </section>
        </router-link>
      </li>
    </ul>
  </section>
</template>

<script>
  export default {
    name: 'SearchBook',
    
    data() {
      return {
        searckBoxSize: '70px',
        placeholder: '书名、作者',
        keyword: '',
        matchingBooks: []
      }
    },

    computed: {
      isShow() {
        return this.keyword.length > 0;
      }
    },

    methods: {
      searchBooks(keyword) {
        this.matchingBooks = this.$store.getters.getBooksByKeyword(keyword);
      },
      hideMatchingBooks() {
        this.matchingBooks = [];
        this.keyword = '';
      }	
    }
  }
</script>

<style lang="scss" scoped>
@import '../assets/styles/common';

.search-book-container {
  position: relative;
  margin-left: auto;
  margin-right: 4rem;

  input {
    border: 3px solid rgb(171, 189, 130);;
    border-radius: 2.0rem;
    padding: .8rem;

    &:focus {
      border-color: $site-primary-color;
      outline: none;
    }
  }
}

.matching-books {
  width: 100%;
  position: absolute;
  z-index: 3;
  list-style-type: none;
  border: 2px solid rgb(243, 9, 9);;
  border-top: none;
  border-radius: 5px;
  background: rgb(218, 236, 210);
}

.matching-book-item {
  border-bottom: 1px solid rgb(151, 147, 147);
  padding: .5rem;
  &:last-child {
    border: none;
  }
  .nav-link-book {
    display: block;
  }
  .book-wraper {
    display: flex;
    flex-direction: row;
  }
  .book-image {
    width: 45px;
    height: 55px;
  }
  .book-info {
    margin-left: 1.8rem;
  }
  .author {
    font-size: 1rem;
    line-height: 1;
    color: #000000;
  }
}
</style>
