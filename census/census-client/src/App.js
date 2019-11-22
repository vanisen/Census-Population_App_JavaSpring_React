import React, {useState} from 'react';
import {Container, Row, Col} from 'react-bootstrap';
import Upload from './components/Upload';
import Response from './components/Response';
import ZipCodesByPopulation from './components/Queries/ZipCodesByPopulation';
import ZipCodesByAgeMedian from './components/Queries/ZipCodesByAgeMedian';
import ZipCodesMostPopulated from './components/Queries/ZipCodesMostPopulated';
import ZipCodesByGender from './components/Queries/ZipCodesByGender';

import 'bootstrap/dist/css/bootstrap.min.css';

const App = () => {
  const [output, setOutput] = useState('');
  return (
    <div className="App mt-4">
      <Container className="census-client">
        <Row>
          <Col>
            <Upload 
                active={output.query === 'upload'}
                setOutput={setOutput}
            />
            <ZipCodesByPopulation
                active={output.query === 'population'}
                setOutput={setOutput}
            />
            <ZipCodesByAgeMedian
                active={output.query === 'age-median'}
                setOutput={setOutput}
            />
            <ZipCodesMostPopulated
                active={output.query === 'top-populated'}
                setOutput={setOutput}
            />
            <ZipCodesByGender
                active={output.query === 'gender'}
                setOutput={setOutput}
            />
          </Col>
          <Col>
            <Response output={output}/>
          </Col>
        </Row>
      </Container>
    </div>
  );
};

export default App;
