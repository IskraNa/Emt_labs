import React from "react";
import { Link, useLocation, useNavigate } from "react-router-dom";

const BookMark = (props) => {

    const navigate = useNavigate();
    const { state } = useLocation();


    const handleChange = (e) => {
        e.preventDefault();
        props.onMark(state.id);
        navigate("/books", { replace: true })
    }

    return (
        <>
            {state.availableCopies !== 0 ? (
                <div className={"container col-lg-12 col-md-11 bg-danger text-light"}>
                    <h1 className={"text-center"}>Mark Book</h1>
                    <p className={"text-center"}>Are you sure you want to mark this book?</p>
                    <button style={{marginLeft : 600 + "px"}}
                        className={""} type="button" onClick={handleChange}>
                        Mark
                    </button>
                </div>
            ) : (
                <div className="container col-lg-12 col-md-11 bg-danger text-light">
                    <h1 className={"text-center"}>Mark Book</h1>
                    <p className={"text-center"}>There are no available copies of this book.</p>
                    <Link style={{marginLeft : 640 + "px"}}
                        className={"text-center text-light"} to="/books">Back</Link>
                </div>
            )}
        </>
    );
}

export default BookMark;