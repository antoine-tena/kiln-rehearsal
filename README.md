> **A fixture of [ion-repo](https://github.com/antoine-tena/ion-repo)'s CI, not a project.** Generated
> by kiln (ion-repo's former name) v0.3.3-rc.2 (Java), then lived in: code, a ticket, edits to
> `CLAUDE.md` and `.claude/settings.json`. ion-repo's end-to-end tests clone it on every release
> branch and every night, go back to commit `8c1f73e` (v0.3.3-rc.2), and run `update --rehearse`
> with the release under test. **Never update it**: `.ion-repo-frozen` keeps it out of
> `ion repo update --all`, which reached it by mistake on 30 October 2026 (undone). Its own CI is off.

# kiln rehearsal

A small repo kiln's CI updates on every release branch, before any real repo.

## Démarrage rapide

Après le clone, depuis la racine du dépôt (prérequis : [uv](https://docs.astral.sh/uv/), un JDK 25 et `unzip`) :

```sh
uv tool install git+https://github.com/antoine-tena/kiln   # une fois par poste
kiln install
```

Puis vérifier le backend : `cd backend && ./mvnw verify`. Détail de chaque commande ci-dessous.

## Équipe

- [@antoine-tena](https://github.com/antoine-tena)

## Organisation

- `backend/` : le backend Java 25 (Maven, sans framework) ; règles dans [`backend/CLAUDE.md`](backend/CLAUDE.md).
- [`CLAUDE.md`](CLAUDE.md) : la charte commune (nommage, taille, git…), pour les humains comme
  pour les agents.
- `.vscode/` : réglages et extensions recommandées, partagés par toute l'équipe.

Le projet est généré et tenu à jour par [kiln](https://github.com/antoine-tena/kiln) (réponses
dans `.copier-answers.yml`). Changer un paramètre (équipe, frameworks, podman…) :
`kiln set <clé>=<valeur>`, sur une branche.

## Installation

Prérequis : ceux du démarrage rapide. Puis, après le clone, depuis la
racine du dépôt :

```sh
kiln install
```

La commande demande une fois le système du poste (Linux, WSL ou macOS), installe les
dépendances (backend) et active les garde-fous du
commit (pre-commit, dont le refus de commiter sur `main` ou `develop`). On peut la relancer sans
risque.

## Lancer le projet

```sh
cd backend && ./mvnw -q package -DskipTests && java -jar target/kiln-rehearsal-0.1.0.jar
```

## Mettre à jour

Sur une branche dédiée (`chore/kiln-update`), avec un arbre propre :

```sh
kiln update            # mises à jour compatibles
kiln update --major    # y compris les versions majeures
```

Elle rapporte les évolutions du modèle (charte, outillage, configuration) sans écraser les
modifications locales, met à jour les dépendances, puis lance les contrôles. Relire le diff,
puis fusionner la branche dans `develop`. Avec Claude Code, le skill `base:maj-kiln` fait tout :
l'outil kiln, puis le dépôt.

## Vérifier le code

```sh
kiln check
```

`./mvnw verify` pour le backend Java (compilation stricte, JUnit, couverture), puis la charte.

## Suivi du travail

Ce qui reste à faire est dans [`docs/backlog/`](docs/backlog/) : `backlog.md` (les tickets, par
priorité), `rejected.md` (ce qui a été refusé) et `urgent.md` (ce que seul un humain peut faire).

## Contribuer

1. Créer une branche depuis la branche par défaut du dépôt (`develop` quand elle existe,
   sinon `main`) : `feat/…`, `fix/…`, voir [BRANCHES].
2. Respecter les règles du [`CLAUDE.md`](CLAUDE.md).
3. Fusionner la branche dans `develop` (`git merge --no-ff`, puis push), sans attendre
   d'approbation : skill `base:fusion` avec Claude Code. Une pull request reste possible pour
   demander un avis. On ne commite jamais directement sur `main` ou `develop`.

## Usage

`cd backend && ./mvnw -q test`
