import styled from "styled-components";
import React from 'react'; 
import arrow from '../../../assets/long-arrow-alt-up-solid.svg';

const buttonone = (props)=>{
    
    return(
        <button {...props}>{props.children}</button>
    );

}
export const StyledButton = styled(buttonone)`
        height:4vh;
        width: 6vw;
        border-radius: 4px;
        border: none;
        text-align: center;
        background-color: #BDB493;
        color: #383736;
        :hover {
            background-color: #ABA17E;
        }
    /* margin-left: 2vw;
    height: 6vh;
    width: 4vw;
    background-image: url(${arrow});
    background-size: 20px;
    background-position: center;
    background-repeat: no-repeat;
    border: none;
    border-radius: 8px;
    background-color: ${props => props.color};
    height: 5vh;
    &:hover {
        background-color: #FCBD1799;
    } */
`
