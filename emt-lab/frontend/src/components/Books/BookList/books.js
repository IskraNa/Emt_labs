import React from "react";
import ReactPaginate from "react-paginate";
import BookTerm from '../BookTerm/bookTerm';
import {Link} from 'react-router-dom';

class Books extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            page: 0,
            size: 5
        }
    }

    render () {

        const offset = this.state.size * this.state.page;
        const nextPageOffset = offset + this.state.size;
        const pageCount = Math.ceil(this.props.books.length / this.state.size);
        const books = this.getBooksPage(offset, nextPageOffset);

        return (
            <div className={"container mm-4 mt-5"}>
                <div className={"row"}>
                    <div className={"row"}>
                        <table className={"table table-striped"}>
                            <thead>
                            <tr>
                                <th scope={"col"}>Name</th>
                                <th scope={"col"}>AvailableCopies</th>
                                <th scope={"col"}>Category</th>
                                <th scope={"col"}>Author</th>
                            </tr>
                            </thead>
                            <tbody>
                            {books}
                            </tbody>
                        </table>
                    </div>
                    <div className="col-12 mb-2 p-0" style={{height : 30 + "px"}}>
                        <div className="row m-0 align-baseline h-100 ms-2 me-0">
                            <div className={"p-md-0 p-sm-0 p-lg-0 h-100 ms-5 me-1"}>
                                <Link className={"btn btn-block btn-dark col-md-11 h-100 d-inline-block p-md-0 p-sm-0 p-lg-0"} to={"/books/add"}>Add a new book</Link>
                            </div>
                        </div>
                    </div>
                </div>
                <ReactPaginate previousLabel={"back"}
                               nextLabel={"next"}
                               breakLabel={<a href="/#"></a>}
                               breakClassName={"break-me"}
                               pageClassName={"me-2 ms-2"}
                               pageCount={pageCount}
                               marginPagesDisplayed={2}
                               pageRangeDisplayed={5}
                               onPageChange={this.handlePageClick}
                               containerClassName={"pagination m-4 justify-content-center"}
                               activeClassName={"active bg-danger text-light"}
                />
            </div>
        )
    }

    handlePageClick = (data) => {
        let selected = data.selected;
        this.setState({
            page: selected
        })
    }

    getBooksPage = (offset, nextPageOffset) => {
        return this.props.books.map((term) => {
            return (
                <BookTerm term={term} onDelete={this.props.onDelete} onEdit={this.props.onEdit}/>
            )
        }).filter((book, index) => {
            return index >= offset && index < nextPageOffset
        })
    }
}

export default Books;