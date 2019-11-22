import React,{useState} from 'react';
import {Card, FormControl, InputGroup, Button} from 'react-bootstrap';
import {getZipCodesMostPopulated} from "../../services/index";

const ZipCodesMostPopulated = ({active, setOutput}) => {

  const [top, setTop] = useState(10);

  const handleChange = (e) => {
    setTop(e.target.value);
  };


  const handleSubmit = async () => {
    const output = await getZipCodesMostPopulated(top);
    setOutput({...output, query: 'top-populated'});
  };

  return (
      <Card  bg={active ? 'light' :''} className="mb-2">
        <Card.Body>
          <Card.Title>Top X number of most populated zipcodes</Card.Title>
          <InputGroup className="mb-1">
            <InputGroup.Prepend>
              <InputGroup.Text>Top</InputGroup.Text>
            </InputGroup.Prepend>
            <FormControl type="number" name="top" min="0" value={top} onChange={handleChange}/>
          </InputGroup>
          <Button variant="primary" onClick={handleSubmit}>Submit</Button>
        </Card.Body>
      </Card>
  );
};

export default ZipCodesMostPopulated;