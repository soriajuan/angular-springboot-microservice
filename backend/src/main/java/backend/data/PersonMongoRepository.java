package backend.data;

import org.springframework.data.mongodb.repository.MongoRepository;

interface PersonMongoRepository extends MongoRepository<PersonMongo, String> {
}
