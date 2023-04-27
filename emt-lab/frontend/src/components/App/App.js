import './App.css';
import React, {Component} from "react";
import {BrowserRouter as Router, Routes, Navigate, Route} from "react-router-dom";
import Authors from '../Authors/authors';
import Books from '../Books/BookList/books';
import BookAdd from '../Books/BookAdd/bookAdd';
import BookMark from '../Books/BookMark/bookMark';
import Categories from '../Categories/categories';
import Countries from '../Countries/countries'
import Header from '../Header/header';
import BookShopService from "../../repository/bookshopRepository";
import BookEdit from "../Books/BookEdit/bookEdit";

class App extends Component {

  constructor(props){
     super(props);
     this.state = {
        authors: [],
        books: [],
        categories: [],
        selectedBook: {}
    }
  }

  render() {
    return (
        <Router>
            <Header></Header>
            <Routes>
                <Route path={"/books/add"} element={<BookAdd
                    books={this.state.books}
                    categories={this.state.categories}
                    authors={this.state.authors}
                    onAddBook={this.addBook}
                />}/>
                <Route path={"/books/edit/:id"} element={<BookEdit
                    categories={this.state.categories}
                    authors={this.state.authors}
                    onEditBook={this.editBook}
                    book={this.state.selectedBook}
                />}/>
                <Route path={"/books"} element={<Books
                    books={this.state.books}
                    onDelete={this.deleteBook}
                    onEdit={this.getBook}
                    onMark={this.markAsTaken}
                />}/>
                <Route path={"/books/mark/:id"} element={<BookMark
                    onMark={this.markAsTaken}
                />}/>
                <Route path={"/categories"} element={<Categories
                    categories={this.state.categories}
                />}/>
                <Route path={"/authors"} element={<Authors
                    authors={this.state.authors}
                />}/>
                <Route path={"/countries"} element={<Countries
                    countries={this.state.countries}
                />}/>
                <Route path="*" element={<Navigate to="/books"/>}/>
            </Routes>
        </Router>
    );
  }

  componentDidMount() {
    this.loadAuthors();
    this.loadBooks();
    this.loadCountries();
    this.loadCategories();
  }

  loadAuthors = () => {
    BookShopService.fetchAuthors()
        .then((data) => {
          this.setState({
            authors: data.data
          })
        });
  }

  loadBooks = () => {
    BookShopService.fetchBooks()
        .then((data) => {
            this.setState({
             books: data.data
            })
        });
  }

  loadCountries = () => {
    BookShopService.fetchCountries()
        .then((data) => {
            this.setState({
                countries: data.data
            })
        });
  }

  loadCategories = () => {
    BookShopService.fetchCategories()
        .then((data) => {
            this.setState({
                categories: data.data
            })
        });
  }

  deleteBook = (id) => {
    BookShopService.deleteBook(id)
        .then(() => {
            this.loadBooks();
        })
  }

  addBook = (name, availableCopies, category, author) => {
    BookShopService.addBook(name, availableCopies, category, author)
        .then(() => {
             this.loadBooks();
        })
  }

  getBook = (id) => {
      BookShopService.getBook(id)
          .then((data) => {
              this.setState({
                  selectedBook: data.data
              })
          });
  }

  editBook = (id, name, availableCopies, category, author) => {
      BookShopService.editBook(id, name, availableCopies, category, author)
          .then(() => {
              this.loadBooks();
          })
  }

  markAsTaken = (id) => {
      BookShopService.markAsTaken(id)
          .then(() => {
              this.loadBooks();
          })
  }

}

export default App;
