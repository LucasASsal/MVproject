import React, { useState } from 'react';
import styled from "styled-components";
import { StyledButton } from '../../atoms/button/StyledButton';
import { insertProduct } from '../../../middleware/serviceHandler';

export default function CreateCard(props) {
    const [codigo, setCodigo] = useState();
    const [descricao, setDescricao] = useState('');

    const [categoria, setcategoria] = useState(1);
    console.log(categoria)
    const [preco, setPreco] = useState();

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
    function insertProductReloader(codigo, categoria, descricao, preco) {
        insertProduct(codigo, categoria, descricao, preco);
        window.location.reload(false);
    }
    const categorias = props.categorias;
    return (

        <NewCard>

            <Column>
                <h3>Cadastrar novo produto</h3>
                Codigo do produto:
                <input style={{ margin: 0 }} type='text' placeholder='codigo' value={codigo} onChange={e => updateCodigoValue(e)}></input>
                Categoria:
                <select name="select" onChange={(e) => updatecategoriaValue(e)}>

                    {categorias.map((categoria) => <option value={categoria.cdCategoria}>{categoria.dsCategoria}</option>)}

                </select>

                Descricao do produto
                <input style={{ margin: 0 }} type='text' placeholder='Descrição' value={descricao} onChange={e => updateDescricaoValue(e)}></input>
                Preco do produto
                <input style={{ margin: 0 }} type='text' placeholder='Preco' value={preco} onChange={e => updatePrecoValue(e)}></input>
            </Column>
            <StyledButton onClick={() => insertProductReloader(codigo, categoria, descricao, preco)}>Cadastrar</StyledButton>
            {console.log(categoria)}

        </NewCard>
    )
}

export const NewCard = styled.div`
    width: 65%;
    height: 100%;
    background-color: white;
    border-radius: 8px;
    display: flex;
    padding: 30px;
    justify-content: space-between;
    align-items: center;
    

`

export const Column = styled.div`
    display: flex;
    flex-direction: column;
    width: 80%;
    input {
        margin: 20px;
    }
`