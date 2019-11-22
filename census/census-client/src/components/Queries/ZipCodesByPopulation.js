import React, {useState} from 'react';
import {Card, InputGroup, FormControl, Button} from 'react-bootstrap';
import {getZipCodesByPopulation} from "../../services/index";

const ZipCodesByPopulation = ({active, setOutput}) => {

  const [data, setData] = useState({min:10,max:200});

  const handleChange = (e) => {
    setData({
        ...data,
        [e.target.name] : e.target.value
    })
  };

  const handleSubmit = async () => {
    const output = await getZipCodesByPopulation(data.min, data.max);
    setOutput({...output, query: 'population'});
  };

  return (
      <Card bg={active ? 'light' :''} className="mb-2">
        <Card.Body>
          <Card.Title>Zipcodes which have a total population within range</Card.Title>
          <InputGroup className="mb-1">
            <InputGroup.Prepend>
              <InputGroup.Text>Min</InputGroup.Text>
            </InputGroup.Prepend>
            <FormControl type="number" name="min" min="0" value={data.min} onChange={handleChange}/>
            <InputGroup.Prepend>
              <InputGroup.Text>Max</InputGroup.Text>
            </InputGroup.Prepend>
            <FormControl type="number"  name="max" min="0" value={data.max} onChange={handleChange}/>
          </InputGroup>
          <Button variant="primary" onClick={handleSubmit}>Submit</Button>
        </Card.Body>
      </Card>
  );
};

export default ZipCodesByPopulation;