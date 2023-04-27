import React from "react";

const categories = (props) => {
    return (
        <div className={"container mm-4 mt-5"}>
            <div className={"row"}>
                <div className={"row"}>
                    <table className={"table table-striped"}>
                        <thead>
                            <h3 style={{color: "darkgray", font: "Serif"}}>Categories</h3>
                        </thead>
                        <tbody>
                         {props.categories.map((category) => {
                             return (
                                 <tr>
                                     <td>{category}</td>
                                 </tr>
                             )
                         })}
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    )
}

export default categories;