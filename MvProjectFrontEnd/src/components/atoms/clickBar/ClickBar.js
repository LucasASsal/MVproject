import styled from "styled-components";
import React from 'react'; 

const bar = (props)=>{
    
    return(
        <div {...props}>{props.children}</div>
    );

}


export const ClickBar = styled(bar)`
    border: solid;
    border-color: black;
    border-width: 1px;
    height: 2vh;
    width: 8vw;
    margin-bottom: 5vh;
    
    
`
export const Progress = styled.div `
    background-color: red;
    width: ${props => props.width};
    height:100%;


`