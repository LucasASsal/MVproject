import React, { useState } from 'react';
import styled from "styled-components";
import api from '../../../api';
import { updateProduct } from '../../../middleware/serviceHandler';



export default function MyComponent(props) {
  function updateInputValue(evt) {
    this.setState({
      inputValue: evt.target.value
    });
  }

  const [codigo, setCodigo] = useState();
  const [descricao, setDescricao] = useState(props.descricao);
  const [categoria, setcategoria] = useState(props.categoria);
  const [preco, setPreco] = useState(props.preco);

  function updateCodigoValue(e) {
    setCodigo(e.target.value);
  }
  function updatecategoriaValue(e) {
    setcategoria(e.target.value);

  }
  function updateDescricaoValue(e) {
    setDescricao(e.target.value);
  }
  function updatePrecoValue(e) {
    setPreco(e.target.value);

  }

  function updateProductReloader(codigo, categoria, descricao, preco) {
    updateProduct(codigo, categoria, descricao, preco);
    window.location.reload(false);
  }
  const categorias = props.categorias;
  return (
    <Content>

      <StyledInputs>
        Codigo do prouto:
        <input type='text' disabled placeholder={props.codigo} value={codigo} onChange={e => updateCodigoValue(e)}></input>
        <select name="select" onChange={(e) => updatecategoriaValue(e)}>

          {categorias.map((categoria) => <option selected={categoria.cdCategoria == props.categoria ? true : false} value={categoria.cdCategoria}>{categoria.dsCategoria}</option>)}

        </select>
       Descricao do produto
        <input type='text' placeholder='Descrição' value={descricao} onChange={e => updateDescricaoValue(e)}></input>
        Preco do produto
        <input type='text' placeholder='Preco' value={preco} onChange={e => updatePrecoValue(e)}></input>
      </StyledInputs>

      <button onClick={() => updateProductReloader(props.codigo, categoria, descricao, preco)}>Atualizar</button>
    </Content >
  )

};


export const AccordionContent = styled(MyComponent)`
    width: 100%;
    height: 100%;
    padding: 20px;
    display: flex;
    justify-content: space-between;
`
const Content = styled.div`
    display: flex;
    justify-content: space-between;
    button {
        height:4vh;
        width: 6vw;
        border-radius: 4px;
        border: none;
        text-align: center;
        background-color: #BDB493;
        color: #383736;
        margin-top: 20px;
        margin-right: 20px;
        :hover {
            background-color: #ABA17E;
        }
        
    }
`
export const StyledInputs = styled.div`
    display: flex;
    flex-direction: column;
    width:80%;
    input {
        margin-bottom: 20px;
        
    }
    
`
