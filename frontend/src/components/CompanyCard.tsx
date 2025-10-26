import React from 'react';
import { Card, Label, Icon } from 'semantic-ui-react';
import { Company } from '../services/api';

interface CompanyCardProps {
  company: Company;
}

export const CompanyCard: React.FC<CompanyCardProps> = ({ company }) => {
  const getStatusColor = (status: string) => {
    switch (status) {
      case 'ACTIVE': return 'green';
      case 'DISSOLVED': return 'grey';
      case 'LIQUIDATION': return 'orange';
      default: return 'grey';
    }
  };

  const getCountryFlag = (country: string) => {
    switch (country) {
      case 'UK': return 'gb';
      case 'FRANCE': return 'fr';
      case 'GERMANY': return 'de';
      default: return 'world';
    }
  };

  return (
    <Card fluid>
      <Card.Content>
        <Card.Header>
          <Icon name={`flag outline`} /> {/* Semantic UI flag */}
          <i className={`${getCountryFlag(company.country)} flag`}></i>
          {company.name}
        </Card.Header>
        <Card.Meta>
          <span className='date'>
            Incorporated: {new Date(company.incorporationDate).toLocaleDateString()}
          </span>
        </Card.Meta>
        <Card.Description>
          <p><strong>Registration:</strong> {company.registrationNumber}</p>
          <p><strong>Type:</strong> {company.companyType}</p>
          <p><strong>Address:</strong> {company.address}</p>
        </Card.Description>
      </Card.Content>
      <Card.Content extra>
        <Label color={getStatusColor(company.status)}>
          {company.status}
        </Label>
        <Label>
          <Icon name='marker' /> {company.country}
        </Label>
      </Card.Content>
    </Card>
  );
};