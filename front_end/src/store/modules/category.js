import * as types from '../mutation_types'
import axios from 'axios'

const state = {
  categories: [],
  books: {},
  allBooks: []
}

const mutations = {
  [types.RECEIVE_CATEGORIES] (state, data) {
    state.categories = data.categories;
    state.books = data.books;
    // add count property to each category object
    state.categories.forEach(category => {
      category.count = state.books[category.name].length;
    });
    
    const temp = Object.values(state.books);
    temp.forEach(item => state.allBooks.push(...item));
  }
}

const actions = {
  fetchCategories ({commit}, url) {
    axios.get(url)
      .then(res => commit(types.RECEIVE_CATEGORIES, res.data));
  }
}

const getters = {
  categories: state => state.categories,
  allBooksCount: state => state.allBooks.length,
  getBooksByCategory: state => category => {
    if (category === 'all') {
      return state.allBooks;
    } else {
      return state.books[category];
    }
  },
  getBookById: state => id => state.allBooks.find(book => book.id === id),
  getBooksByKeyword: state => keyword => {
    const matchingBooks = state.allBooks.filter(book => 
      book.title.toLowerCase().includes(keyword) || book.author.some(author => author.toLowerCase().includes(keyword))
    )
    return matchingBooks;
  }
}

export default {
  state,
  mutations,
  actions,
  getters
}