import React from 'react';
import { Card1 } from '../card/Card1';
import { AccordionContent } from './AccordionContent';

import { Collapse, CardBody, Card, CardHeader } from 'reactstrap';

const getCategory = function getCategory(category, listCategories) {
  var categoria = null;
  if (listCategories != null && category != null) {

    listCategories.forEach((value) => { if (value.cdCategoria == category) categoria = `${value.dsCategoria} (NR_PERCENTUAL:${value.nrPercentual})` });
  }
  return categoria;
}
export class Accordion extends React.Component {

  constructor(props) {
    super(props);
    this.toggle = this.toggle.bind(this);
    this.state = { collapse: 0, cards: [1] };
  }

  toggle(e) {
    let event = e.target.dataset.event;
    this.setState({ collapse: this.state.collapse === Number(event) ? 0 : Number(event) });
  }

  render() {

    const { cards, collapse } = this.state;
    return (
      <div className="container">
        <h3 className="page-header">Descricao do produto: {this.props.name}</h3>
        <h3>Preco do produto: {this.props.preco}R$</h3>
        <h3>Categoria do prouto: {getCategory(this.props.categoria, this.props.categorias)}</h3>
        {cards.map(index => {
          return (
            <Card style={{ marginBottom: '1rem' }} key={index}>
              <CardHeader ><Card1 codigo={this.props.codigo} onClick={this.toggle} data-event={index} /></CardHeader>
              <Collapse isOpen={collapse === index}>

                <CardBody><AccordionContent codigo={this.props.codigo} preco={this.props.preco} descricao={this.props.name} categoria={this.props.categoria} categorias={this.props.categorias} /></CardBody>
              </Collapse>
            </Card>
          )
        })}

      </div>
    );
  }
}




