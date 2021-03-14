import React from "react";
import './css/loader.scss';

export const Loader=()=>{

    return(
        <div className="loading">
            <span className="circle" id="circle1"> </span>
            <span className="circle" id="circle2"> </span>
            <span className="circle" id="circle3"> </span>
        </div>
    );
};
